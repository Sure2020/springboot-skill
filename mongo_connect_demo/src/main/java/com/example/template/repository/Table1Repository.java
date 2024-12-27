/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Table1Repository
 * Date Created : 2024-12-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-27       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.repository;

import com.example.template.entity.Table1;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: com.example.template.repository
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-27
 **/

public interface Table1Repository extends MongoRepository<Table1, String> {

    // 自定义查询方法
    Table1 findByName(String name);

}
