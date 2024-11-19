/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : KafkaProducer
 * Date Created : 2024-11-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-18       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.kafka;

import com.alibaba.fastjson.JSONObject;
import com.example.template.entity.DotaHero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @program: com.example.template.test
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-18
 **/
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendADotaHero() {
        DotaHero dotaHero = new DotaHero("虚空假面", "敏捷", "男");

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(KafkaTopic.A_DOTA_HERO, JSONObject.toJSONString(dotaHero));

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("kafka sendMessage error, throwable = {}, topic = {}, data = {}", throwable, KafkaTopic.A_DOTA_HERO, dotaHero);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringDotaHeroSendResult) {
                log.info("kafka sendMessage success topic = {}, data = {}",KafkaTopic.A_DOTA_HERO, dotaHero);
            }
        });

        log.info("kafka sendMessage end");

    }

}