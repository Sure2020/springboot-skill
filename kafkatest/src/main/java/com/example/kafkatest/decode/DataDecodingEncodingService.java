/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DataDecodingEncodingService
 * Date Created : 2023-07-31
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-07-31       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.kafkatest.decode;

import lombok.extern.slf4j.Slf4j;
import org.nustaq.serialization.FSTConfiguration;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: com.example.kafkatest.decode
 * @description: xxx
 * @author: w15021
 * @create: 2023-07-31
 **/

@Slf4j
@Service
public class DataDecodingEncodingService implements DecodingEncodingService {
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