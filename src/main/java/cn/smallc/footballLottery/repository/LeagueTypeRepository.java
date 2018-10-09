package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.Repository;
import cn.smallc.footballLottery.entity.LeagueType;
import org.springframework.stereotype.Service;

@Service
public class LeagueTypeRepository extends Repository<LeagueType,ILeagueTypeRepository> {

    public LeagueType getByNickName(String nickName){
        return repository.getByNickName(nickName);
    }

    public LeagueType getByLeagueName(String leagueName){
        return  repository.getByLeagueName(leagueName);
    }

}
