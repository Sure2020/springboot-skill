/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyCustomEventListener
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

package com.example.template.sync;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-25
 **/
//1.事件监听器（实现ApplicationListener接口方式）
/*
@Component
public class MyCustomEventListener implements ApplicationListener<MyCustomEvent> {

    @Override
    public void onApplicationEvent(MyCustomEvent event) {
        String message = event.getMessage();
        System.out.println("Interface Received custom event - " + message);
        // 这里可以添加更多的处理逻辑
    }
}*/


//2. 事件监听器（注解方式）
@Component
public class MyCustomEventListener {

    @EventListener
    public void handleEvent(MyCustomEvent event) {
        String message = event.getMessage();
        System.out.println("Annotation Received custom event - " + message);
        // 这里可以添加更多的处理逻辑
    }
}
