/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UserRepository
 * Date Created : 2022-08-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-08-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.javatpoint.repository;

/**
 * @program: com.javatpoint.repository
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-17
 **/
import org.springframework.data.repository.CrudRepository;
import com.javatpoint.model.UserRecord;
public interface UserRepository extends CrudRepository<UserRecord, String>
{
}