/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UdpClient
 * Date Created : 2024-01-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-23       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.testmain;

/**
 * @program: com.example.template.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2024-01-23
 **/
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    public static void main(String[] args) {
        // 目标服务器地址和端口
        String serverAddress = "192.168.110.26";
        int serverPort = 10137;

        try {
            // 创建一个DatagramSocket实例
            DatagramSocket socket = new DatagramSocket();

            // 要发送的消息
            String message = "Hello, Server!";

            // 将消息转换为字节数组
            byte[] buffer = message.getBytes();

            // 获取目标服务器的InetAddress对象
            InetAddress address = InetAddress.getByName(serverAddress);

            // 创建一个包含数据和目标地址信息的DatagramPacket对象
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, serverPort);

            // 发送数据包
            socket.send(packet);

            System.out.println("Message sent to the server: " + message);

        } catch (IOException e) {
            System.err.println("Error occurred when sending the message: " + e.getMessage());
        }
    }
}
