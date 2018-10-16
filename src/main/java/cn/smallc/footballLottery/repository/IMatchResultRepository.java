package cn.smallc.footballLottery.repository;

import cn.smallc.footballLottery.common.db.IRepository;
import cn.smallc.footballLottery.entity.MatchResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IMatchResultRepository extends IRepository<MatchResult> {

    void deleteMatchResultByMatchCode(@Param("matchCodes") List<String> matchCodes);

    MatchResult getByMatchCode(@Param("matchCode")String matchCode);

}
