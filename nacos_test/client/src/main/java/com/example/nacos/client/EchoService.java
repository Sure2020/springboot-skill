/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : EchoService
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

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: com.example.nacos.client
 * @description: xxx
 * @author: Admin
 * @create: 2024-09-14
 **/
//@FeignClient(name = "spring-cloud-nacos-producer")
//public interface EchoService {
//    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
//    String echo(@PathVariable("str") String str);
//}