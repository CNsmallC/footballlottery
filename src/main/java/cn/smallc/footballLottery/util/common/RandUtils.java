package cn.smallc.footballLottery.util.common;

import java.util.UUID;


public class RandUtils {

    public static String uuid(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
