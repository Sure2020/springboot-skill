/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestCapitalLibrary
 * Date Created : 2024-02-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.main;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: com.example.test.main
 * @description: xxx
 * @author: w15021
 * @create: 2024-02-04
 **/
public class TestCapitalLibrary {
    private static final ThreadLocal<Map<String, Integer>> threadLocal = ThreadLocal.withInitial(HashMap::new);
    public static void main(String[] args) {
//        int inNum = 1000;
//        inNum = (int) (inNum * 1.003);
//        inNum *=1.003;
//        inNum = (int) (inNum * 1.003);

//        System.out.println(inNum);
        Map<String, Integer> map = new HashMap<>();
        map.put("你好",1);
        System.out.println(map.toString());
        int myint = map.get("你好");
        System.out.println(myint);

        // 创建一个Random对象
        Random random = new Random();

        // 生成一个[0.0, 1.0)范围内的double类型随机数
        double randomPart = random.nextDouble();

        // 缩放到指定区间，这里我们缩放到(0.95, 0.97]区间
        double result = 0.95 + (0.97 - 0.95) * randomPart;

        // 输出结果
        System.out.println("随机生成的数: " + result);
        System.out.println(1-Double.valueOf("0.95"));
        System.out.println("#####");
        int inNum = 4506;
        int inNumYouer = 3677;
        int flowNumErtong = 590;
        double tempcoefficient = 0.9672546522953007;
        int num = (int) (1.0*inNum/(inNumYouer + inNum) * flowNumErtong * tempcoefficient);
        System.out.println(num);
        System.out.println(3677+4506);
        System.out.println(1.0*4506/(3677+4506));
        int tempInt = (int) (1.0*inNumYouer*0.94 - 3232);
        System.out.println(tempInt);

        System.out.println("###3333333333");
        threadLocal.get().put("a",1);
        System.out.println(threadLocal.get().get("a"));
        threadLocal.remove();

        System.out.println("#####");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "a");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);

        System.out.println(jsonArray);
        correct(jsonArray);
        System.out.println(jsonArray);

        System.out.println("位操作");
        System.out.println(1+(3-1)/2);
        System.out.println(1+(3-1>>1));
    }
    public static void correct(JSONArray jsonArray){
        for (Object object:jsonArray){
            JSONObject jsonObject = (JSONObject) object;
            if (jsonObject.containsKey("a")){
                jsonObject.put("a","b");
            }
        }

    }
}