/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2024-12-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

import com.example.template.sync.EventPublisher;
import com.example.template.sync.MyCustomEvent;
import com.example.template.sync.TestEvent;
import com.example.template.sync.TestObject;
import com.example.template.test.TestEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-14
 **/
@RestController
public class TestController {
    @Autowired
    EventPublisher eventPublisher;
    @GetMapping("test")
    public String test(){
        TestObject testObject = new TestObject();
        testObject.setId(UUID.randomUUID().toString());
        TestEvent testEvent = new TestEvent(this);
        testEvent.setData(testObject);

        MyCustomEvent myCustomEvent = testEvent;
        TestEvent testEvent1 = (TestEvent) myCustomEvent;
        System.out.println(myCustomEvent.getData());
        System.out.println(testEvent1.getData().getId());

        eventPublisher.publishEvent("wfs");
        return "testing";
    }
}