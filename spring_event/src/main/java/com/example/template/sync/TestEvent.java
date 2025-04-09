/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestEvent
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

package com.example.template.sync;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: com.example.template.sync
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-14
 **/
@Getter
@Setter
public class TestEvent extends MyCustomEvent {
    private TestObject data;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String msg, TestObject data) {
        super(source, msg, data);
    }

}