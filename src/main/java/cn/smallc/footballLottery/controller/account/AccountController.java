package cn.smallc.footballLottery.controller.account;

import cn.smallc.footballLottery.support.SharedRepositoryFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import cn.smallc.footballLottery.entity.account.Account;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("账号接口")
@RestController
@RequestMapping("/account")
public class AccountController {



//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Account getAccountById(@PathVariable("id") int id){
//        Account account = SharedRepositoryFactory.getAccountRepository().get(id);
//        return account;
//    }

//    @ApiOperation("获取账号")
//    @ApiImplicitParam(name="id", value= "账号id" , required = true)
//    @RequestMapping(value = "/get",method = RequestMethod.GET)
//    public Account get(int id){
//        Account account = SharedRepositoryFactory.getAccountRepository().get(id);
//        return account;
//    }
//
//    @PostMapping("/transfer")
//    public String transfer(){
//        SharedRepositoryFactory.getAccountRepository().transfer();
//        return "成功";
//    }




}
