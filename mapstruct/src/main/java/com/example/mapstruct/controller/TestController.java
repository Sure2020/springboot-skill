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

package com.example.mapstruct.controller;

import com.example.mapstruct.dto.Device;
import com.example.mapstruct.dto.DeviceDTO;
import com.example.mapstruct.dto.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.mapstruct
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-13
 **/
@RestController
public class TestController {
    @Autowired
    DeviceMapper deviceMapper;
    @GetMapping("/test")
    public Object test () {
        Device device1 = new Device("a", "dev1", "water");
        Device device2 = new Device("b", "dev2", "water");
        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);

        //DeviceDTO deviceDTO = new DeviceDTO();
        List<DeviceDTO> deviceDTOs = new ArrayList<>();
        deviceDTOs = deviceMapper.devicesToDeviceDTOs(devices);
        return deviceDTOs.toString();
    }
}