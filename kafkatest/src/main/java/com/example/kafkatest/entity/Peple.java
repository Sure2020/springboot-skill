/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Peple
 * Date Created : 2023-08-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.kafkatest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: com.example.kafkatest.entity
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-01
 **/
@Data
public class Peple implements Serializable {
    private int age;
}