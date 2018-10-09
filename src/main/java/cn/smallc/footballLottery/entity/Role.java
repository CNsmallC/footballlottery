package cn.smallc.footballLottery.entity;

import cn.smallc.footballLottery.common.ientity.WebAggregateRoot;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author smallC
 * @Date 2018/10/9
 * @Description
 */
public class Role extends WebAggregateRoot {
    @ApiModelProperty(value = "角色ID")
    private int ID;
    @ApiModelProperty(value = "角色名称")
    private String roleName;

}
