package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.Repository;
import cn.smallc.footballLottery.entity.Match;
import cn.smallc.footballLottery.entity.Score;
import cn.smallc.footballLottery.support.SharedRepositoryFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchRepository extends Repository<Match,IMatchRepository> {


    @Transactional
    public void insertMatches(List<Match> matches){

        repository.batchInsert(matches);

        List<Score> scores = new ArrayList<>();

        matches.stream().forEach(match->{
            List<Score> one_scores = match.getScores();
            one_scores.stream().forEach(m->m.setMatchCode(match.getMatchCode()));
            scores.addAll(one_scores);
        });

        SharedRepositoryFactory.getScoreRepository().batchInsert(scores);
    }

    /**
     * 获取指定时间内的比赛信息
     */
    public List<Match> getMatchesByTime(Date startTime,Date endTime){

        List<Match> matches = new ArrayList<>();
        matches = repository.getMatchesByTime(startTime,endTime);

        return matches;
    }


    /**
     * 更新赛事信息
     * @param matches
     */
    @Transactional
    public void updateMatches(List<Match> matches){
        List<String> deleteMatchCodes = matches.stream().map(m->m.getMatchCode()).distinct().collect(Collectors.toList());

        List<Score> scores = new ArrayList<>();

        matches.stream().forEach(match->{
            List<Score> one_scores = match.getScores();
            one_scores.stream().forEach(m->m.setMatchCode(match.getMatchCode()));
            scores.addAll(one_scores);
        });

//        List<Score> insertScores = matches.stream().flatMap(m->m.getScores().stream()).collect(Collectors.toList());
        SharedRepositoryFactory.getScoreRepository().deleteScoresByMatchCode(deleteMatchCodes);

        SharedRepositoryFactory.getScoreRepository().batchInsert(scores);
    }

    public List<String> getAllMatchCode(){
        return repository.getAllMatchCode();
    }


}
