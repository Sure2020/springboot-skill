/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UserController
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

package com.javatpoint.controller;

/**
 * @program: com.javatpoint.controller
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-17
 **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.model.UserRecord;
import com.javatpoint.service.UserService;
import java.util.List;
@RestController
public class UserController
{
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public List<UserRecord> getAllUser()
    {
        return userService.getAllUsers();
    }
    @RequestMapping(value="/add-user", method=RequestMethod.POST)
    public void addUser(@RequestBody UserRecord userRecord)
    {
        userService.addUser(userRecord);
    }
}