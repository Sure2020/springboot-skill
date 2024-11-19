/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2024-11-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-19       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

import com.example.template.kafka.KafkaConsumer;
import com.example.template.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-19
 **/
@RestController
public class TestController {
    @Autowired
    KafkaProducer kafkaProducer;
    @Autowired
    KafkaConsumer kafkaConsumer;
    @GetMapping("/test/send")
    public Object test()
    {
        System.out.println("testing");
        kafkaProducer.sendADotaHero();
        return "success";
    }

    /*@GetMapping("/test/recieve")
    public Object recieve()
    {
        System.out.println("testing");
        kafkaConsumer.recieve();
        return "success";
    }*/
}