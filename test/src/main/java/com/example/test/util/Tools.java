/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MySleep
 * Date Created : 2023-05-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-05-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: com.example.test.util
 * @description: xxx
 * @author: w15021
 * @create: 2023-05-16
 **/
@Slf4j
public class Tools {
    public static void mySleep(String message, int seconds) {
        for (int i = 0; i < seconds; i++) {
            log.info(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}