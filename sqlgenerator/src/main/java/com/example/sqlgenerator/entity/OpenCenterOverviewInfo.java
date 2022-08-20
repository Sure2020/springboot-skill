/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : OpenCenterOverviewInfo
 * Date Created : 2022-08-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-08-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.sqlgenerator.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: com.example.sqlgenerator.entity
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-20
 **/
//@Data
//@Entity
//@Table(name = "opencenter_overview")
public class OpenCenterOverviewInfo {
    private Integer productCount;

    private Integer deviceCount;
    // transaction per second 每秒事务处理量
    private Integer modelCount;
    private Integer entityCount;
    private Integer apiCount;

    // API授权信息
    private String apiServerAddress;
    private String apiAuthType;
    private String apiAuthToken;

    // 数据订阅
    private String publishType;
    private String publishAddress;
    private String publishAuthType;
    private String publishAuthInfo;
    private String subscribeTopic;

}