package cn.smallc.footballLottery.entity;

import cn.smallc.footballLottery.common.ientity.IAggregateRoot;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class Match  implements IAggregateRoot {

    @ApiModelProperty(value = "ID")
    private int ID;
    @ApiModelProperty(value = "联赛")
    private LeagueType leagueType;
    @ApiModelProperty(value = "比赛时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date matchTime;
    @ApiModelProperty(value = "最后投注时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endBuyTime;
    private int todayMatchID;
    private boolean isHot;
    //比赛时间_主队_客队 的 MD5加密
    @ApiModelProperty(value = "唯一赛事码")
    private String matchCode;

    @ApiModelProperty(value = "主队")
    private Team homeTeam;
    @ApiModelProperty(value = "客队")
    private Team awayTeam;

    @ApiModelProperty(value = "让球数量")
    private int rq;
    @ApiModelProperty(value = "比分玩法赔率list")
    private List<Score> scores;
    @ApiModelProperty(value = "赛果")
    private MatchResult matchResult;



//    @Override
//    public String toString() {
//         return "Match{" +
//                "\nID=" + ID +
//                "\n, leagueType=" + leagueType +
//                "\n, matchTime=" + matchTime +
//                "\n, endBuyTime=" + endBuyTime +
//                "\n, todayMatchID=" + todayMatchID +
//                "\n, isHot=" + isHot +
//                "\n, matchCode=" + matchCode +
//                "\n, homeTeam=" + homeTeam.toString() +
//                "\n, awayTeam=" + awayTeam.toString() +
//                "\n, rq=" + rq +
//                "\n, scores=" + scores +
//                '}';
//    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public Date getEndBuyTime() {
        return endBuyTime;
    }

    public void setEndBuyTime(Date endBuyTime) {
        this.endBuyTime = endBuyTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRq() {
        return rq;
    }

    public void setRq(int rq) {
        this.rq = rq;
    }

    public LeagueType getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(LeagueType leagueType) {
        this.leagueType = leagueType;
    }

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public int getTodayMatchID() {
        return todayMatchID;
    }

    public void setTodayMatchID(int todayMatchID) {
        this.todayMatchID = todayMatchID;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }
}
