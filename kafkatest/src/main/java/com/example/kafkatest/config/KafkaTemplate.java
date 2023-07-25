/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : KafkaTemplate
 * Date Created : 2023-07-25
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-07-25       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.kafkatest.config;

/**
 * @program: com.example.kafkatest.config
 * @description: xxx
 * @author: w15021
 * @create: 2023-07-25
 **/

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Data
@Component
@Slf4j
public class KafkaTemplate {

    @Value("${iotdata.core.queue.kafka.bootstrap.servers}")
    private String servers;

    @Value("${iotdata.core.queue.kafka.topic}")
    private String topic;

    @Value("${iotdata.core.queue.kafka.group_id}")
    private String groupId;

    @Value("${iotdata.core.queue.kafka.enable_auto_commit}")
    private String enableAutoCommit;

    @Value("${iotdata.core.queue.kafka.fetch.max.bytes}")
    private Integer fetchMaxBytes;

    @Value("${iotdata.core.queue.kafka.max.poll.records}")
    private String maxPollRecords;



//    @Value("${queue.kafka.auto_offset_reset_config}")
//    private String autoOffsetResetConfig;

    private KafkaConsumer<String, String> consumer;

    @PostConstruct
    public void kafkaTemplate() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, fetchMaxBytes);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        this.consumer = new KafkaConsumer<String, String>(props);
        log.info("test topic: {}", topic);
        String tempTopic = "ruleEngineToIotdata,tb_upper_app.notifications.iot-data";
        this.consumer.subscribe(Arrays.asList(tempTopic.split(",")));
    }

    public ConsumerRecords<String, String> doPoll(long durationInMillis) {
        return consumer.poll(Duration.ofMillis(durationInMillis));
    }

    protected void doUnsubscribe() {
        if (consumer != null) {
            consumer.unsubscribe();
            consumer.close();
        }
    }

    public void commitAsync() {
        consumer.commitAsync();
    }

}


