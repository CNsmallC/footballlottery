package cn.smallc.footballLottery.common.web;

import cn.smallc.footballLottery.util.common.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	@Autowired
	protected HttpServletRequest request;

	protected String getRemoteIP() {
		return HttpUtils.getRemoteIP(request);
	}
}
