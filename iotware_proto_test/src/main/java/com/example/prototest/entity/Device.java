/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Device
 * Date Created : 2023-09-25
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-09-25       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.prototest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: com.example.prototest.entity
 * @description: xxx
 * @author: w15021
 * @create: 2023-09-25
 **/
@Data
@AllArgsConstructor
public class Device implements Serializable {
    String id;
    String name;

}