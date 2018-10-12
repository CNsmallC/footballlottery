package cn.smallc.footballLottery.controller.match;

import cn.smallc.footballLottery.biz.MatchBiz;
import cn.smallc.footballLottery.common.web.JsonResult;
import cn.smallc.footballLottery.entity.Match;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author smallC
 * @Date 2018/10/11
 * @Description
 */

@Api(value = "比赛接口")
@RequestMapping("/match")
@RestController
public class MatchController {

    @ApiOperation(value = "获取当天的赛事信息")
    @GetMapping("/getTodayMatchTest")
    public static JsonResult getMatchTest(){

        JsonResult jsonResult = null;

        List<Match> todayMatches = MatchBiz.getTodayMatch();

        jsonResult = jsonResult.success(todayMatches,"今日比赛获取成功(当天凌晨到第二天中午12点)");

        return jsonResult;
    }

}
