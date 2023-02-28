/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : BusinessServiceImpl
 * Date Created : 2023-02-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-02-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.udpserver.service.impl;

/**
 * @program: com.example.udpserver.service.impl
 * @description: xxx
 * @author: w15021
 * @create: 2023-02-01
 **/

import com.example.udpserver.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * BusinessServiceImpl
 *
 * @author wliduo[i@dolyw.com]
 * @date 2020/5/20 11:59
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private static final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Override
    @Async("threadPoolTaskExecutor")
    public void udpHandleMethod(String message) throws Exception {
        logger.info("业务开始处理");
        Thread.sleep(3000);
        logger.info("业务处理完成");
    }
}
