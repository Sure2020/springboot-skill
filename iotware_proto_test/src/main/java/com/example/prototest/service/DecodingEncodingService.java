/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DecodingEncodingService
 * Date Created : 2023-09-26
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-09-26       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.prototest.service;

import java.util.Optional;
/**
 * @program: com.example.prototest.service
 * @description: xxx
 * @author: w15021
 * @create: 2023-09-26
 **/

public interface DecodingEncodingService {
    <T> Optional<T> decode(byte[] byteArray);

    <T> byte[] encode(T msq);
}

