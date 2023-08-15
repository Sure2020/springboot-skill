/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2023-08-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.kafkatest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kafkatest.entity.Device;
import com.example.kafkatest.entity.Student;
import com.example.kafkatest.entity.TestClass;

import java.util.Map;

/**
 * @program: com.example.kafkatest
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-02
 **/
public class TestMain {
    public static void main(String[] args) {
        // 测试将类对象转换为map对象
        System.out.println("testing");
        TestClass testClass = new TestClass();
        Device device = new Device();
        device.setDeviceId("a");
        Student student = new Student();
        student.setName("testStu");
        testClass.setDevName("testclass");
        testClass.setDevice(device);
        testClass.setStudent(student);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(testClass);
        Map<String, Object> map = JSON.parseObject(jsonObject.toString(), Map.class);
        System.out.println(map);
        for (String key: map.keySet()) {
            System.out.println(key + ":" +map.get(key));
        }

    }
}