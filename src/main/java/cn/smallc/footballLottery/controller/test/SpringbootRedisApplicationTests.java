package cn.smallc.footballLottery.controller.test;

import cn.smallc.footballLottery.support.SharedGlobalFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    public static Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);
    @Test
    public void contextLoads() {
    }
    
    @Test
    public void testRedis(){
        SharedGlobalFactory.getRedisUtils().set("name","smallc");
        SharedGlobalFactory.getRedisUtils().set("age","11");


        logger.info(SharedGlobalFactory.getRedisUtils().get("name").toString());
        logger.info(SharedGlobalFactory.getRedisUtils().get("age").toString());
    }
}