/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : PinboTrail
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

package com.example.template.entity;

import lombok.Data;

/**
 * @program: com.example.template.entity
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-22
 **/
@Data
public class PinboTrail {
    private String tagId;
    private String targetId;
    private String startTime;
    private String endTime;
    private String targetName;
    private int pageNo;
    private int pageSize;

}