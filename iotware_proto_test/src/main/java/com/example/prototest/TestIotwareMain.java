/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestIotwareMain
 * Date Created : 2023-09-21
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-09-21       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.prototest;

import com.example.prototest.entity.Device;
import com.example.prototest.iotwareproto.PlatApiProtos;
import com.example.prototest.iotwareproto.TransportProtos;
import com.example.prototest.service.DecodingEncodingService;
import com.example.prototest.service.ProtoWithFSTService;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @program: com.example.prototest.iotware
 * @description: xxx
 * @author: w15021
 * @create: 2023-09-21
 **/
public class TestIotwareMain {
    public static void main(String[] args) throws UnsupportedEncodingException, InvalidProtocolBufferException {
        ProtoWithFSTService protoWithFSTService = new ProtoWithFSTService();

        Device device = new Device("testDeviceID", "testDeviceName");

        TransportProtos.EntityUpdateMsg entityUpdateMsg = TransportProtos.EntityUpdateMsg.newBuilder()
                .setEntityType("DEVICE")
                .setData(ByteString.copyFrom(protoWithFSTService.encode(device))).build();

        PlatApiProtos.ToUpperAppNotificationMsg toUpperAppNotificationMsg =
                PlatApiProtos.ToUpperAppNotificationMsg.newBuilder().
                setEntityUpdateMsg(entityUpdateMsg).build();
        byte[] bytes = toUpperAppNotificationMsg.toByteArray();
        System.out.println("序列化后的数据：" + Arrays.toString(bytes));

        System.out.println("##########################");

        PlatApiProtos.ToUpperAppNotificationMsg toUpperAppNotificationMsgParsed = PlatApiProtos.ToUpperAppNotificationMsg.parseFrom(bytes);
        TransportProtos.EntityUpdateMsg entityUpdateMsgNewParsed = toUpperAppNotificationMsgParsed.getEntityUpdateMsg();
        Optional<Device> deviceParsed = protoWithFSTService.decode(entityUpdateMsgNewParsed.getData().toByteArray());
        System.out.println("EntityType: " + entityUpdateMsgNewParsed.getEntityType());
        System.out.println("Device: " + deviceParsed);
    }
}