package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.IRepository;
import cn.smallc.footballLottery.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IScoreRepository extends IRepository<Score> {
    List<Score> getByMatchID(int matchID);

    void deleteScoresByMatchCode(@Param("matchCode") List<String> matchCode);

    List<Score> getScoresByMatchCode(@Param("matchCode")String matchCode);

}
