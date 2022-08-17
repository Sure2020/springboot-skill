/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UserService
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

package com.javatpoint.service;

/**
 * @program: com.javatpoint.service
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-17
 **/
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.model.UserRecord;
import com.javatpoint.repository.UserRepository;
@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    public List<UserRecord> getAllUsers()
    {
        List<UserRecord>userRecords = new ArrayList<>();
        userRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }
    public void addUser(UserRecord userRecord)
    {
        userRepository.save(userRecord);
    }
}