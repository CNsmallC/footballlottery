package cn.smallc.footballLottery.entity;

import cn.smallc.footballLottery.common.ientity.IAggregateRoot;
import cn.smallc.footballLottery.entity.enums.Em_PlayType;
import io.swagger.annotations.ApiModelProperty;

public class Score implements IAggregateRoot {

    @ApiModelProperty(value = "ID")
    private int ID;
    //  不同玩法
    @ApiModelProperty(value = "不同玩法")
    private Em_PlayType playType;
    //    比分和赔率的特殊字符串  比分|赔率,比分|赔率...
    @ApiModelProperty(value = "比分和赔率的特殊字符串")
    private String score_Odds;
    @ApiModelProperty(value = "比赛码")
    private String matchCode;

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Em_PlayType getPlayType() {
        return playType;
    }

    public void setPlayType(Em_PlayType playType) {
        this.playType = playType;
    }

    public String getScore_Odds() {
        return score_Odds;
    }

    public void setScore_Odds(String score_Odds) {
        this.score_Odds = score_Odds;
    }

}
