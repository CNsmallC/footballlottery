package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.IRepository;
import cn.smallc.footballLottery.entity.LeagueType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ILeagueTypeRepository extends IRepository<LeagueType> {

    LeagueType getByNickName(String nickName);

    LeagueType getByLeagueName(String leagueName);


}
