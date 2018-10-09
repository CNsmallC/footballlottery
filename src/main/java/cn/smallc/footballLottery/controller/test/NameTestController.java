package cn.smallc.footballLottery.controller.test;

import cn.smallc.footballLottery.bean.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableConfigurationProperties({ConfigBean.class})
public class NameTestController {


    @Autowired
    private ConfigBean configBean;
//    @Value("${my.name}")
//    private String name;
//
//    @Value("${my.age}")
//    private int age;
//
    @RequestMapping("/name")
    public String name(){
        return configBean.getGreeting()+" >>>>"
                +configBean.getName()+" >>>>"+ configBean.getUuid()
                +" >>>>"+configBean.getMax();
    }


}
