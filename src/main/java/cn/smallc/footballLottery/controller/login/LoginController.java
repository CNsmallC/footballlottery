package cn.smallc.footballLottery.controller.login;

import cn.smallc.footballLottery.common.web.JsonResult;
import cn.smallc.footballLottery.common.web.MyController;
import cn.smallc.footballLottery.support.SharedRepositoryFactory;
import cn.smallc.footballLottery.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * @Author smallC
 * @Date 2018/10/10
 * @Description
 */

@RestController
public class LoginController extends MyController {

    @GetMapping(value = "/notLogin")
    public JsonResult notLogin() {
        return JsonResult.success("您尚未登陆！");
    }

    @GetMapping(value = "/notRole")
    public JsonResult notRole() {
        return JsonResult.success("您没有权限！");
    }

    @GetMapping(value = "/logout")
    public JsonResult logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return JsonResult.success("成功注销！");
    }

    @PostMapping("/login")
    public JsonResult login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        String realPassword = SharedRepositoryFactory.getUserRepository().getPasswordByUsername(username);
        if (realPassword == null) {
            return JsonResult.fail("用户名错误");
        } else if (!realPassword.equals(password)) {
            return JsonResult.fail("密码错误");
        } else {
            return JsonResult.success(JWTUtil.createToken(username),"登录成功");
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public JsonResult unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return JsonResult.success(message);
    }


}
