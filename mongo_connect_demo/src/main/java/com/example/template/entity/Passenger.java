/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Passenger
 * Date Created : 2024-11-29
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-29       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.entity;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-29
 **/

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document的collection属性设置的是在mongo库中的集合名称
@Document(collection = "passenger")
@Data
public class Passenger {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}