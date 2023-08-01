/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Device
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

package com.example.kafkatest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: com.example.kafkatest.entity
 * @description: xxx
 * @author: w15021
 * @create: 2023-07-31
 **/
@Data
public class Device implements Serializable {
    private String deviceId;
    private String deviceName;
}