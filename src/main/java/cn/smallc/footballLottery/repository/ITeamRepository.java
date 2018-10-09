package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.IRepository;
import cn.smallc.footballLottery.entity.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ITeamRepository extends IRepository<Team> {

    int insertTeam(Team team);

    void insertLeagueTypeRelation(Map<String, Integer> map);

    Team findByTeamName_C(String teamName_C);

    Team findByNickName_C(String nickName_C);


}
