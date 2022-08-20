/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : OpenAPIMonitorInfo
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @program: com.example.sqlgenerator.entity
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-20
 **/
@Data
@Entity
@Table(name = "api_monitor")
public class OpenAPIMonitorInfo {
    @Id
    @Column(name = "info_id", columnDefinition = "uuid")
    protected UUID id;
    private Integer totalCallCount;
    private Integer dailyCallCount;
    // transaction per second 每秒事务处理量
    private Integer transactionPerSecond;
    private Integer realTimeResponseTime;
    private Integer failedCallCount;
}