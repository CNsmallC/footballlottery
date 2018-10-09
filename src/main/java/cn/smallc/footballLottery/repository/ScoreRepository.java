package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.Repository;
import cn.smallc.footballLottery.entity.Score;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreRepository extends Repository<Score,IScoreRepository> {

    public List<Score> getByMatchID(int matchID){
        return repository.getByMatchID(matchID);
    }

    public void deleteScoresByMatchCode(List<String> matchCode){
        repository.deleteScoresByMatchCode(matchCode);
    }

    public List<Score> getScoresByMatchCode(String matchCode){
        return repository.getScoresByMatchCode(matchCode);
    }

}
