/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : CronService
 * Date Created : 2024-03-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: com.example.template.service
 * @description: xxx
 * @author: w15021
 * @create: 2024-03-11
 **/
@Service
public class CronService {
    @Autowired JdbcExample jdbcExample;
    @Scheduled(cron = "*/20 * * * * ?")
    public void cron(){
        System.out.println(System.currentTimeMillis());
        jdbcExample.fetchData();
    }

}