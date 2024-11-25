/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyCustomEvent
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

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-25
 **/
@Getter
public class MyCustomEvent extends ApplicationEvent {

    private String message;

    public MyCustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}