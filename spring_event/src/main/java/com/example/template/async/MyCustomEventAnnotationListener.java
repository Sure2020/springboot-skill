/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyCustomEventAnnotationListener
 * Date Created : 2024-11-25
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-25       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.async;

import com.example.template.sync.MyCustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-25
 **/
@Component
public class MyCustomEventAnnotationListener {

    @Async
    @EventListener
    public void handleEvent(MyCustomEvent event) {
        String message = event.getMessage();
        System.out.println("Annotation Received custom event - " + message + " threadName: " + Thread.currentThread().getName());
        // 这里可以添加更多的处理逻辑
    }
}