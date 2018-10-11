package cn.smallc.footballLottery.controller.exception;

import cn.smallc.footballLottery.common.web.JsonResult;
import cn.smallc.footballLottery.common.web.MyController;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author smallC
 * @Date 2018/10/10
 * @Description
 */

@RestControllerAdvice
public class ExceptionController extends MyController {


    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public JsonResult handleShiroException(Exception ex) {
        return JsonResult.fail(ex.getMessage());
    }

//    捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public JsonResult handle401() {
        return JsonResult.fail("您没有权限访问！");
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public JsonResult globalException(HttpServletRequest request, Throwable ex) {
        return JsonResult.fail("访问出错，无法访问: " + ex.getMessage());
    }



}
