/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ExamMain
 * Date Created : 2023-06-29
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-06-29       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.main;
import org.ejml.simple.SimpleMatrix;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: com.example.test.main
 * @description: xxx
 * @author: w15021
 * @create: 2023-06-29
 **/
public class ExamMain {
    /*public static void main(String[] args) {
        *//*String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s2 == s1);
        System.out.println(s2.equals(s1));*//*
        *//*int x =1;
        int y=2;int z=3;
        System.out.println(y+=z--/++x);*//*
        System.out.println("testing");
        String str = "1.81";
        float l = Float.valueOf(str);
        System.out.println(l);
    }*/
    // 外层 Map 的 key 表示设备，内层 Map 存储该设备与其他设备之间的心跳状态
    private Map<String, Map<String, Boolean>> heartbeatMap = new LinkedHashMap();//new HashMap<>();

    // 根据初始设备列表初始化
    public void initializeDevices(String[] devices) {
        heartbeatMap.clear();
        for (String device : devices) {
            addDevice(device);
        }
    }

    // 增加一个新设备
    public void addDevice(String device) {
        if (heartbeatMap.containsKey(device)) {
            System.out.println("设备已存在: " + device);
            return;
        }
        // 为新设备创建一个内层 Map，并将已有设备状态设为 false
        Map<String, Boolean> newDeviceMap = new HashMap<>();
        for (String other : heartbeatMap.keySet()) {
            // 对于新设备，与已有设备之间默认心跳状态为 false
            newDeviceMap.put(other, false);
            // 同时更新已有设备的内层 Map，增加新设备记录，状态默认为 false
            heartbeatMap.get(other).put(device, false);
        }
        // 将新设备加入总的 heartbeatMap 中
        heartbeatMap.put(device, newDeviceMap);
    }

    // 删除一个设备
    public void removeDevice(String device) {
        if (!heartbeatMap.containsKey(device)) {
            System.out.println("设备不存在: " + device);
            return;
        }
        // 从外层 Map 中移除该设备
        heartbeatMap.remove(device);
        // 从所有其他设备的内层 Map 中移除该设备的记录
        for (Map<String, Boolean> innerMap : heartbeatMap.values()) {
            innerMap.remove(device);
        }
    }

    // 更新设备间的心跳状态
    public void updateHeartbeat(String source, String target, boolean status) {
        if (heartbeatMap.containsKey(source) && heartbeatMap.get(source).containsKey(target)) {
            heartbeatMap.get(source).put(target, status);
        } else {
            System.out.println("更新失败，可能不存在设备: " + source + " -> " + target);
        }
    }

    // 获取两个设备间的心跳状态
    public boolean getHeartbeatStatus(String source, String target) {
        if (heartbeatMap.containsKey(source) && heartbeatMap.get(source).containsKey(target)) {
            return heartbeatMap.get(source).get(target);
        }
        return false;
    }

    // 输出所有设备间的心跳状态
    public void printHeartbeatStatus() {
        for (Map.Entry<String, Map<String, Boolean>> entry : heartbeatMap.entrySet()) {
            String device = entry.getKey();
            System.out.println("设备: " + device);
            for (Map.Entry<String, Boolean> innerEntry : entry.getValue().entrySet()) {
                System.out.println("  -> " + innerEntry.getKey() + " : " + innerEntry.getValue());
            }
        }
    }

    // 测试示例
    public static void main(String[] args) {
        ExamMain manager = new ExamMain();
        // 初始设备列表
        String[] devices = {"deviceA", "deviceB", "deviceC"};
        manager.initializeDevices(devices);

        // 模拟更新心跳状态：deviceA 收到 deviceB 的心跳
        manager.updateHeartbeat("deviceA", "deviceB", true);
        System.out.println("初始化后状态：");
        manager.printHeartbeatStatus();

        // 添加新设备 deviceD
        System.out.println("\n添加设备 deviceD：");
        manager.addDevice("deviceD");
        manager.printHeartbeatStatus();

        // 删除设备 deviceB
        System.out.println("\n删除设备 deviceB：");
        manager.removeDevice("deviceB");
        manager.printHeartbeatStatus();
    }
}

