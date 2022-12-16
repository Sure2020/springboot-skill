/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ResultVO
 * Date Created : 2022-12-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-12-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.jwt.entity;

/**
 * @program: com.example.jwt.entity
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-14
 **/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
