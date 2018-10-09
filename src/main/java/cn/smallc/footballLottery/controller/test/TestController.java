package cn.smallc.footballLottery.controller.test;

import cn.smallc.footballLottery.biz.MatchBiz;
import cn.smallc.footballLottery.common.MKLogBack;
import cn.smallc.footballLottery.common.web.JsonResult;
import cn.smallc.footballLottery.common.web.MyController;
import cn.smallc.footballLottery.entity.Match;
import cn.smallc.footballLottery.entity.account.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Api(value = "测试接口")
@RestController
public class TestController extends MyController {

    @ApiOperation(value = "获取当天的赛事信息")
    @GetMapping("/getTodayMatchTest")
    public static JsonResult getMatchTest(){

        JsonResult jsonResult = null;

        List<Match> todayMatches = MatchBiz.getTodayMatch();

        jsonResult = jsonResult.success(todayMatches,"今日比赛获取成功(当天凌晨到第二天中午12点)");

        return jsonResult;
    }


    @ApiOperation(value = "hw测试")
    @GetMapping("/")
    public String index(){
        return "Hello World!";
    }

    public static void main(String[] args) {
//        String s = "[aaaaa[\"[[[]]\"][\"]bbbbb]";
//
//        MKLogBack.getInstance().debug(s);
//        MKLogBack.getInstance().debug(s.replaceAll("[\\[\\]]","").replaceAll("[\"]",""));
//
//
        List<Account> list = new ArrayList<>();

        list.add(new Account(1,"name1",1));
        list.add(new Account(2,"name2",2));
        list.add(new Account(3,"name3",3));

        MKLogBack.getInstance().debug(list);

//        Collections.sort(list, new Comparator<Account>() {
//            @Override
//            public int compare(Account o1, Account o2) {
//                return o2.getId()-o1.getId();
//
//            }
//        });

//        list.sort((Account a1,Account a2) -> a1.getId() - a2.getId());

        list.sort(Comparator.comparing(Account::getId));
        MKLogBack.getInstance().debug(list);

        Collections.reverse(list);
        MKLogBack.getInstance().debug(list);

    }



}
