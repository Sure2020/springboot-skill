/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ProtoWithFSTService
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

/**
 * @program: com.example.prototest.service
 * @description: xxx
 * @author: w15021
 * @create: 2023-09-26
 **/

import lombok.extern.slf4j.Slf4j;
import org.nustaq.serialization.FSTConfiguration;
import java.util.Optional;

@Slf4j
public class ProtoWithFSTService implements DecodingEncodingService {
    private final FSTConfiguration config = FSTConfiguration.createDefaultConfiguration();

    @Override
    public <T> Optional<T> decode(byte[] byteArray) {
        try {
            @SuppressWarnings("unchecked")
            T msg = byteArray != null && byteArray.length > 0 ? (T) config.asObject(byteArray) : null;
            return Optional.ofNullable(msg);
        } catch (IllegalArgumentException e) {
            log.error("Error during deserialization message, [{}]", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public <T> byte[] encode(T msq) {
        return config.asByteArray(msq);
    }
}