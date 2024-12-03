/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : PassengerRepository
 * Date Created : 2024-12-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.repository;

import com.example.template.entity.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @program: com.example.template.repository
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-02
 **/
public interface PassengerRepository extends MongoRepository<Passenger, String> {
    List<Passenger> findByName(String name);
    Integer countByName(String name);
}
