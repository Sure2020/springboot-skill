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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "aa");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        System.out.println(jsonArray);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("list", jsonArray);
        System.out.println(jsonObject2);

        List<Testmember> list = JSONObject.parseArray(jsonObject2.getString("list"), Testmember.class);
        System.out.println(list.get(0).getId2());
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