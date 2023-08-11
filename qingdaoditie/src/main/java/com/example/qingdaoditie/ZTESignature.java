/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ZTESignature
 * Date Created : 2023-08-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.qingdaoditie;

/**
 * @program: com.example.qingdaoditie
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-09
 **/
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @program: com.h3c.iotdata.core.qingdaoditie.utils
 * @description: xxx
 * @author: w15021
 * @create: 2023-07-03
 **/
@Slf4j
public class ZTESignature {
    public static String generateRequestSignature(Map<String, Object> params, Map<String, Object> requestBody) {
        Map<String, Object> paramsMap = new TreeMap<>();
        paramsMap.putAll(params);
        Map<String, Object> resultMap = new TreeMap<>();
        if (!CollectionUtils.isEmpty(requestBody)) {
            List<Map<String, Object>> oldDataList = (List<Map<String, Object>>) requestBody.get("dataList");
            if (!CollectionUtils.isEmpty(oldDataList)) {
                List<Map<String, Object>> newDataList = new ArrayList<>();
                for (Object oldData : oldDataList) {
                    Map<String, Object> requestBodyMap = new TreeMap<>();
                    Map<String, Object> map = (Map<String, Object>) oldData;
                    List<Map<String, Object>> oldPerformanceMap = (List<Map<String, Object>>) map.get("performanceList");
                    List<Map<String, Object>> newPerformanceMap = new ArrayList<>();
                    if (!CollectionUtils.isEmpty(oldPerformanceMap)) {
                        for (Object performance : oldPerformanceMap) {
                            Map<String, Object> requestPerformanceMap = new TreeMap<>();
                            Map<String, Object> performanceMap = (Map<String, Object>) performance;
                            requestPerformanceMap.putAll(performanceMap);
                            newPerformanceMap.add(requestPerformanceMap);
                        }
                        map.put("performanceList", newPerformanceMap);
                    }
                    List<Map<String, Object>> oldDeviceUpdateMap = (List<Map<String, Object>>) map.get("cellList");
                    List<Map<String, Object>> newDeivceUpdateMap = new ArrayList<>();
                    if (!CollectionUtils.isEmpty(oldDeviceUpdateMap)) {
                        for (Object deviceUpdate : oldDeviceUpdateMap) {
                            Map<String, Object> requestDeviceUpdateMap = new TreeMap<>();
                            Map<String, Object> deviceUpdateMap = (Map<String, Object>) deviceUpdate;
                            requestDeviceUpdateMap.putAll(deviceUpdateMap);
                            newDeivceUpdateMap.add(requestDeviceUpdateMap);
                        }
                        map.put("cellList", newDeivceUpdateMap);
                    }

                    requestBodyMap.putAll(map);
                    newDataList.add(requestBodyMap);
                }
                requestBody.put("dataList", newDataList);
            }
            resultMap.putAll(requestBody);
            //paramsMap.put("body", JSON.toJSONString(resultMap));
        }
        Set<String> keySet = paramsMap.keySet();
        StringBuilder paramsBuffer = new StringBuilder();
        for (String key : keySet) {
            paramsBuffer.append(key).append("=").append(paramsMap.get(key));
        }
        log.info("generate signature by parameter: {}", paramsBuffer.toString());
        return md5Encrypt(paramsBuffer.toString()).toUpperCase();
    }

    public static String md5Encrypt (String message) {
        try {
            log.info("before encrypt by md5: {}", message);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(message.getBytes(StandardCharsets.UTF_8));
            String res = Hex.encodeHexString(messageDigest.digest());
            log.info("after encrypt by md5: {}", res);
            return res;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return "";
        }
    }
}