/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ResultVOUtil
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

public class ResultVOUtil {
    public static ResultVO<Object> success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO<Object> success() {
        return ResultVOUtil.success(null);
    }

    public static ResultVO<Object> fail(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("失败");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO<Object> fail() {
        return ResultVOUtil.fail(null);
    }
}
