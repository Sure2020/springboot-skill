/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UdpSimpleClient
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 默认发送方式
 *
 * @author wliduo[i@dolyw.com]
 * @date 2020/5/20 15:53
 */
@Service
public class UdpSimpleClient {

    private final static Logger logger = LoggerFactory.getLogger(UdpSimpleClient.class);

    @Value("${udp.port}")
    private Integer udpPort;

    public void sendMessage(String message) {
        logger.info("发送UDP: {}", message);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", udpPort);
        byte[] udpMessage = message.getBytes();
        DatagramPacket datagramPacket = null;
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            datagramPacket = new DatagramPacket(udpMessage, udpMessage.length, inetSocketAddress);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("发送成功");
    }
}
