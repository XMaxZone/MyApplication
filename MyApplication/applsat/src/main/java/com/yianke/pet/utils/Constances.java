package com.yianke.pet.utils;

/**
 * Created by Administrator on 2017/7/16 0016.
 */

public class Constances {

    private static String IP = "http://119.28.20.68:8080/GoodlifeApi";
    private static String shequ = "/api/v1/article/get?";
    public static String zhixun_main = IP+"/api/v1/article/get";
    public static String yaowen = IP + shequ +"data={\"navigation\":\"2\"}";
    public static String dongman = IP + shequ +"data={\"navigation\":\"3\"}";
    public static String xuet = IP + shequ +"data={\"navigation\":\"4\"}";
    public static String guanf = IP + shequ +"data={\"navigation\":\"2\"}";


    public static String luntan  = IP + "/api/v1/posts/findList?" + "data={\"navigationId\":\"8\"}";

}
