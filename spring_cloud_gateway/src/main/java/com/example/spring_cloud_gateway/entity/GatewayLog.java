/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : GatewayLog
 * Date Created : 2022-12-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-12-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.spring_cloud_gateway.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: com.example.spring_cloud_gateway.entity
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-20
 **/
@Data
public class GatewayLog {
    /**访问实例*/
    private String targetServer;
    /**请求路径*/
    private String requestPath;
    /**请求方法*/
    private String requestMethod;
    /**协议 */
    private String schema;
    /**请求体*/
    private String requestBody;
    /**响应体*/
    private String responseData;
    /**请求ip*/
    private String ip;
    /**请求时间*/
    private Date requestTime;
    /**响应时间*/
    private Date responseTime;
    /**执行时间*/
    private long executeTime;
}