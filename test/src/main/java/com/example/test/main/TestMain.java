/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2023-04-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-04-18       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.main;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.util.UpperAppType;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: com.example.test.main
 * @description: xxx
 * @author: w15021
 * @create: 2023-04-18
 **/
public class TestMain {
    public static void main(String[] args) {
        System.out.println("test");
        /*urlReplaceHostAndPort("https://192.18.11.1:890/a/b/c",
                "127.0.0.1",
                8080);*/
        /*MyMessage myMessage = new MyMessage();
        myMessage.setMsg("raw");
        testReturnString(myMessage);
        System.out.println("at last: " + myMessage.toString());*/

        //System.out.println(UpperAppType.valueOf("IOT_CLASS"));


        //String testStr = "ruleEngineToIotdata,tb_upper_app.notifications.iot-data";

        /*String testStr = "ruleEngineToIotdata";
        System.out.println(testStr.split(",")[0]);
        //System.out.println(testStr.split(",")[1]);
        List<String> testList = Arrays.asList(testStr);
        System.out.println(testList.get(0));
        System.out.println(Arrays.asList(testStr.split(",")));

        System.out.println(System.currentTimeMillis());*/




        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "aa");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        System.out.println(jsonArray);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("list", jsonArray);
        System.out.println(jsonObject2);

        List<Testmember> list = JSONObject.parseArray(jsonObject2.getString("list"), Testmember.class);
        System.out.println(list.get(0).getId2());*/

        /*long linuxTimestamp = System.currentTimeMillis();//1629536400; // 你的Linux时间戳
        //long linuxTimestamp = 1629536400; // 你的Linux时间戳

        // 创建SimpleDateFormat对象，指定日期时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        // 将Linux时间戳转换为Java的Date对象
        Date date = new Date(linuxTimestamp); // 需要将时间戳乘以1000，因为Java中时间戳是以毫秒为单位的

        // 格式化Date对象为字符串
        String formattedDate = sdf.format(date);

        System.out.println("Formatted date: " + formattedDate);*/

        UUID uuid = UUID.randomUUID();

        // 获取 UUID 的 16 位字符串表示
        String uuidString = uuid.toString().replace("-", "").substring(0, 16);

        System.out.println("16 位 UUID: " + uuidString);

        BigDecimal recommend1 = new BigDecimal("0.1");
        BigDecimal recommend2 = BigDecimal.valueOf(0.1);
        BigDecimal recommend3 = new BigDecimal(0.1);

        System.out.println(Double.toString(0.1));
        System.out.println(recommend1);
        System.out.println(recommend2);
        System.out.println(recommend3);
        Set<Integer> myKeyset = new HashSet<>();
        myKeyset.add(1);
        System.out.println(myKeyset.contains(1));
        int[] myIntArr = new int[] {1};



    }
    public static String urlReplaceHostAndPort(String urlForReplace, String hostToReplace, Integer portToReplace) {
        String finalURL = "";
        try {
            URL oldURL = new URL(urlForReplace);
            String protocol = oldURL.getProtocol();
            System.out.println(protocol);
            String file = oldURL.getFile();
            System.out.println(file);
            URL newURL = new URL(protocol, hostToReplace, portToReplace, file);
            finalURL = newURL.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return finalURL;
    }

    public static boolean testReturnString (MyMessage returnString){
        System.out.println(returnString.toString());
        returnString.setMsg("changed");
        return true;
    }
}