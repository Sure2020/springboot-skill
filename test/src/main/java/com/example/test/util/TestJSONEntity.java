/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestJSONEntity
 * Date Created : 2023-08-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @program: com.example.test.util
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-16
 **/
@Data
public class TestJSONEntity {
    private String id;
    private Object params;
    private JsonNode obj;
    private String str;
    /*TestJSONEntity(String id, JSON params){
        System.out.println("init test");
        this.id = id;
        this.params = params;
    }*/
}