package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.Repository;
import cn.smallc.footballLottery.entity.MatchResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchResultRepository extends Repository<MatchResult,IMatchResultRepository> {

    public void deleteMatchResultByMatchCode(List<String> matchCodes){
        repository.deleteMatchResultByMatchCode(matchCodes);
    }

    public MatchResult getByMatchCode(String matchCode){
        return repository.getByMatchCode(matchCode);
    }

}
