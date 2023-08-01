/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2023-07-31
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-07-31       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.kafkatest.controller;

import com.example.kafkatest.decode.DataDecodingEncodingService;
import com.example.kafkatest.decode.DecodingEncodingService;
import com.example.kafkatest.entity.Device;
import com.example.kafkatest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

/**
 * @program: com.example.kafkatest.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-07-31
 **/
@RestController
public class TestController {
    @Autowired
    DecodingEncodingService decodingEncodingService;
    @GetMapping("/test/get")
    public String testGet() {
        Device device = new Device();
        device.setDeviceName("test device");
        device.setDeviceId(UUID.randomUUID().toString());
        byte[] bytes = decodingEncodingService.encode(device);

        //byte[] bytes = "testabc".getBytes();
        System.out.println("bytes: " + bytes);

        Optional<String> deviceOptional_string = decodingEncodingService.decode(bytes);
        if (deviceOptional_string.isPresent()) {
            Object obj = deviceOptional_string.get();
            System.out.println(obj.toString());
        } else {
            System.out.println("no string");
        }

        Optional<Object> deviceOptional_object = decodingEncodingService.decode(bytes);
        if (deviceOptional_object.isPresent()) {
            Object obj = deviceOptional_object.get();
            System.out.println(obj.toString());
        } else {
            System.out.println("no obj");
        }


        Optional<Device> deviceOptional = decodingEncodingService.decode(bytes);
        if (deviceOptional.isPresent()) {
            Device device1 = deviceOptional.get();
            System.out.println(device1);
        } else {
            System.out.println("no");
        }



        Optional<Student> deviceOptional_student = decodingEncodingService.decode(bytes);
        if (deviceOptional_student.isPresent()) {
            Student student = deviceOptional_student.get();
            System.out.println(student.toString());
        } else {
            System.out.println("no student");
        }

        return "test";
    }
}