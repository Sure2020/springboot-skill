/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : SwitchInt
 * Date Created : 2023-10-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.main;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: com.example.test.main
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-17
 **/
public class SwitchInt {
    public static void main(String[] args) {
        JSONObject param = new JSONObject();
        param.put("data_type", 1);
        int dataType = -1;
        System.out.println(dataType);
        if (param.containsKey("data_type")){
            dataType = param.getIntValue("data_type");
            System.out.println(dataType);
        } else {
            System.out.println("no key");
        }



        /*switch (dataType){
            case 1:
                System.out.println("case 1");
                break;
            case 9:
                System.out.println("case 9");
                break;
            default:
                System.out.println("no");
        }*/
        //pushMessage(param);
    }
    public static void pushMessage(JSONObject param){
        Logger log = LoggerFactory.getLogger(SwitchInt.class);
        log.debug("[pushMessage] param: {}", param);
        int dataType = -1;
        try {
            dataType = param.getIntValue("data_type");
            log.info("data_type: {}", dataType);
        } catch (Exception e) {
            log.error("消息缺少data_type字段,停止推送");
            e.printStackTrace();
            return;
        }
        switch (dataType) {
            case 1:
                log.debug("设备位置信息上报");
                String deviceLocationUrl = System.getenv("QINGDAO_DEVICE_LOCATION");
                //String deviceAlarmUrl = System.getenv("QINGDAO_DEVICE_ALARM");
                if (deviceLocationUrl == null){
                    log.error("无设备位置推送地址");
                    return;
                }
                log.debug("deviceLocationUrl from env: {}", deviceLocationUrl);
                //postToMultiUrl(deviceLocationUrl, param);
                break;
            case 9:
                log.debug("设备告警信息上报");
                String deviceAlarmUrl = System.getenv("QINGDAO_DEVICE_ALARM");
                if (deviceAlarmUrl == null){
                    log.error("无设备告警推送地址");
                    return;
                }
                log.debug("deviceAlarmUrl from env: {}", deviceAlarmUrl);
                //postToMultiUrl(deviceAlarmUrl, param);
                break;
            default:
                log.warn("暂不支持的报文类型， data_type为: {}", dataType);
        }
    }


}