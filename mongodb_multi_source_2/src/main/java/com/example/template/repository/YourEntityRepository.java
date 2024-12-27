/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : R
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

/**
 * @program: com.example.template.repository
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-27
 **/

import com.example.template.entity.Table1;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface YourEntityRepository extends MongoRepository<Table1, String> {

    // 自定义查询方法
    Table1 findByName(String name);

}