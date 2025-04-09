/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2024-12-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.test;


import com.example.template.sync.TestEvent;
import com.example.template.sync.TestObject;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * @program: com.example.template.test
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-13
 **/
public class TestMain {
    public static void main(String[] args) {
        System.out.println("testing");
        // 获取当前 UTC 时间
        ZonedDateTime utcDateTime = ZonedDateTime.now(java.time.ZoneOffset.UTC);

        // 截断到秒 (去掉毫秒和纳秒部分)
        utcDateTime = utcDateTime.truncatedTo(ChronoUnit.SECONDS);

        // 使用 ISO_INSTANT 格式化器来格式化日期时间
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

        // 格式化日期时间
        String formattedDateTime = utcDateTime.format(formatter);

        // 打印格式化后的日期时间，格式: yyyy-MM-dd'T'HH:mm:ssZ
        System.out.println(formattedDateTime);


        // 将 ZonedDateTime 转换为 Instant 对象
        // 然后再将 Instant 转换为 Date 对象
        Date date = Date.from(utcDateTime.toInstant());

        // 打印 Date 对象
        System.out.println(date);  // 打印 Date 对象，输出会是默认的 Date.toString() 格式
        System.out.println(date.getTime());
        Date date2 = new Date();
        System.out.println(date2.getTime());

        for(TestEnum testEnum: TestEnum.values()){
            System.out.println(testEnum);
            System.out.println(testEnum.getName());
        }

        System.out.println(UUID.randomUUID().toString());

    }
}