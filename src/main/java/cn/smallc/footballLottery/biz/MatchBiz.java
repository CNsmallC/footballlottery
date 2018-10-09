package cn.smallc.footballLottery.biz;

import cn.smallc.footballLottery.entity.Match;
import cn.smallc.footballLottery.support.SharedRepositoryFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author smallC
 * @Date 2018/10/8
 * @Description
 */
public class MatchBiz {

    public static List<Match> getTodayMatch(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);

        Date startTime = calendar.getTime();

        calendar.add(Calendar.DATE,1);
        calendar.set(Calendar.HOUR_OF_DAY,12);

        Date endTime = calendar.getTime();

        List<Match> todayMatch = SharedRepositoryFactory.getMatchRepository().getMatchesByTime(startTime,endTime);

        return todayMatch;
    }

    public static List<Match> getAllMatch(){

        return null;
    }

    public static List<Match> getMatchByTime(Date startTime,Date endTime){


        return null;
    }





}
