/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : BusinessService
 * Date Created : 2023-02-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-02-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.udpserver.service;

/**
 * @program: com.example.udpserver.service
 * @description: xxx
 * @author: w15021
 * @create: 2023-02-01
 **/
public interface BusinessService {
    void udpHandleMethod(String message) throws Exception;
}
