package com.example.kafkatest.config;

import com.alibaba.fastjson.JSON;
import com.example.kafkatest.entity.Device;
import com.example.kafkatest.entity.DotaHero;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class KafkaConsumer {

    @Autowired
    private KafkaConfig kafkaConfig;

    /**
     * 我认为通过kafka的方式处理设备上下线消息，需要保证消息的顺序消费，比如生产者端，topic只创建一个patition，或者发送消息时指定patition或者key。
     * 消费者端，其实只需创建一个消费者，因为只需消费一个patition中的消息。
     */
    @PostConstruct
    public void process() {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("acpool-kafka-process").build(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(() -> {
            while (true) {
                try {
                    ConsumerRecords<String, String> consumerRecords = kafkaConfig.doPoll(1000L);
                    if (consumerRecords.isEmpty()) {
                        Thread.sleep(1000L);
                    } else {
                        consumerRecords.forEach(msg -> {
                            log.info("[ACPOOL][KAFKA] Receive Message, topic: [{}], value: [{}]", msg.topic(), msg.value());
                            DotaHero dotaHero = JSON.parseObject(msg.value(), DotaHero.class);

                            System.out.println(dotaHero);
                        });
                    }
                } catch (Exception e) {
                    log.warn("[ACPOOL][KAFKA] Exception Message:", e);
                } finally {
                    kafkaConfig.commitAsync();
                }
            }
        });
        threadPoolExecutor.shutdown();
    }

    public static Integer readInt16(String str, int offset) {
        return toDecimal(str.substring(offset, offset + 16), true);
    }

    public static Integer readInt8(String str, int offset) {
        return toDecimal(str.substring(offset, offset + 8), true);
    }

    /**
     * @param str
     * @param flag true: 读取有符号, false: 读取无符号
     * @return
     */
    public static Integer toDecimal(String str, Boolean flag) {
        if (flag && str.startsWith("1")) {
            StringBuilder build = new StringBuilder();
            char[] ele = str.substring(1).toCharArray();
            for (char c : ele) {
                build.append(c == '1' ? "0" : "1");
            }
            return ~Integer.valueOf(String.valueOf(build), 2);
        }
        return Integer.valueOf(str, 2);
    }
}
