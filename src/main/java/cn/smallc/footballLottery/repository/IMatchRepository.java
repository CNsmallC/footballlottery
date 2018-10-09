package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.IRepository;
import cn.smallc.footballLottery.entity.Match;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface IMatchRepository extends IRepository<Match> {

    List<String> getAllMatchCode();

    List<Match> getMatchesByTime(@Param("startTime")Date startTime,@Param("endTime")Date endTime);

}
