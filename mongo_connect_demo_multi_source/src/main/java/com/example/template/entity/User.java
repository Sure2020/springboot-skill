/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : User
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

package com.example.template.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: com.example.template.entity
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-02
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -4328989516223829865L;
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

}