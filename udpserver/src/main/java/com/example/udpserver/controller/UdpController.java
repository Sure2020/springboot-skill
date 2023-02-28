/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UdpController
 * Date Created : 2023-02-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-02-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.udpserver.controller;

/**
 * @program: com.example.udpserver.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-02-02
 **/

import com.example.udpserver.client.UdpIntegrationClient;
import com.example.udpserver.client.UdpSimpleClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UdpController
 *
 * @author wliduo[i@dolyw.com]
 * @date 2020/5/19 14:46
 */
@RestController
@RequestMapping("/udp")
public class UdpController {

    /**
     * logger
     */
    private final static Logger logger = LoggerFactory.getLogger(UdpController.class);

    @Autowired
    private UdpSimpleClient udpSimpleClient;

    @Autowired
    private UdpIntegrationClient udpIntegrationClient;

    /**
     * UdpSimpleClient发送
     *
     * @param
     * @return java.lang.String
     * @throws
     * @author wliduo[i@dolyw.com]
     * @date 2020/5/20 16:35
     */
    @GetMapping("/send1")
    public String send1() throws Exception {
        udpSimpleClient.sendMessage("aA");
        return "send1 success";
    }

    /**
     * UdpIntegrationClient发送
     *
     * @param
     * @return java.lang.String
     * @throws
     * @author wliduo[i@dolyw.com]
     * @date 2020/5/20 10:15
     */
    @GetMapping("/send2")
    public String send2() throws Exception {
        udpIntegrationClient.sendMessage("bB");
        return "send2 success";
    }
}
