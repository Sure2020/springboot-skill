/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LoginController
 * Date Created : 2023-12-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-22
 **/

import com.example.template.entity.User;
import com.example.template.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录Controller
 */
@RestController
public class LoginController
{

    static Map<Integer, User> userMap = new HashMap<>();

    static {
        //模拟数据库
        User user1 = new User(1,"张三","123456");
        userMap.put(1, user1);
        User user2 = new User(2,"李四","123123");
        userMap.put(2, user2);
    }

    /**
     * 模拟用户 登录
     */
    @RequestMapping("/login")
    public String login(User user)
    {
        for (User dbUser : userMap.values()) {
            if (dbUser.getUserName().equals(user.getUserName()) && dbUser.getPassword().equals(user.getPassword())) {
                System.out.println("登录成功！生成token！");
                String token = JwtUtil.createToken(dbUser);
                return token;
            }
        }
        return "failed";
    }
}