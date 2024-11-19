/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : KafkaConsumer
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

import com.example.template.entity.DotaHero;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.template.test
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-18
 **/
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaTopic.A_DOTA_HERO, groupId = "${spring.kafka.consumer.group-id}")
    private void kafkaConsumer(ConsumerRecord<String, DotaHero> consumerRecord) {

        log.info("kafkaConsumer: topic = {}, msg = {}", consumerRecord.topic(), consumerRecord.value());

    }
}