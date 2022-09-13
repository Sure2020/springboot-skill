/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2022-09-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-09-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.mapstruct
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-13
 **/
@RestController
public class TestController {
    @Autowired DeviceMapper deviceMapper;
    @GetMapping("/test")
    public Object test () {
        Device device = new Device();
        device.setId("a");
        device.setName("testdev");
        device.setType("water");
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO = deviceMapper.deviceToDeviceDto(device);
        return deviceDTO.toString();
    }
}