/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : TestController
 * Date Created : 2024-09-14
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-09-14       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.example.nacos.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: com.example.nacos.client
 * @description: xxx
 * @author: Admin
 * @create: 2024-09-14
 **/
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private EchoService echoService;

    @RequestMapping("/hi")
    public String hi(String name) {
        // 调用生产者 sayhi 方法，并返回结果
        return restTemplate.getForObject("http://spring-cloud-nacos-producer/sayhi/" + name,
                String.class);
    }
    @RequestMapping(value = "/echo-rest/{str}", method = RequestMethod.GET)
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://spring-cloud-nacos-producer/echo/" + str,
                String.class);
    }

//    @RequestMapping(value = "/echo-feign/{str}", method = RequestMethod.GET)
//    public String feign(@PathVariable String str) {
//        return echoService.echo(str);
//    }

}