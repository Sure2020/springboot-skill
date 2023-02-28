/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UdpIntegrationClientConfig
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

package com.example.udpserver.client;

/**
 * @program: com.example.udpserver.client
 * @description: xxx
 * @author: w15021
 * @create: 2023-02-02
 **/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;

/**
 * IntegrationClientConfig
 *
 * @author wliduo[i@dolyw.com]
 * @date 2020/5/20 15:59
 */
@Configuration
public class UdpIntegrationClientConfig {

    @Value("${udp.port}")
    private Integer udpPort;

    @Bean
    @ServiceActivator(inputChannel = "udpOut")
    public UnicastSendingMessageHandler unicastSendingMessageHandler() {
        UnicastSendingMessageHandler unicastSendingMessageHandler = new UnicastSendingMessageHandler("localhost", udpPort);
        return unicastSendingMessageHandler;
    }

}
