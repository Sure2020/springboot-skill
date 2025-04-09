/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : EventType
 * Date Created : 2024-12-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.test;

/**
 * @program: com.example.template.test
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-13
 **/
public enum EventTypeEnum {
    // 根级事件
    DEVICE_EVENT("1", "设备事件"),

    // 子级事件：设备事件下的设备上线事件、设备下线事件
    DEVICE_ONLINE(DEVICE_EVENT, "2", "设备上线事件"),
    DEVICE_OFFLINE(DEVICE_EVENT, "3", "设备下线事件"),

    // 孙级事件：设备事件下的子级设备事件，设备故障、恢复等
    DEVICE_FAULT(DEVICE_ONLINE, "4", "设备故障事件"),
    DEVICE_RECOVERY(DEVICE_OFFLINE, "5", "设备恢复事件"),

    // 重孙级事件：设备故障下的某个具体事件
    DEVICE_OVERHEAT(DEVICE_FAULT, "06", "设备过热事件"),
    DEVICE_POWER_FAILURE(DEVICE_FAULT, "07", "设备电力故障");

    // 事件的父类编码
    private final String parentCode;
    // 事件的子类编码
    private final String code;
    // 事件描述
    private final String description;

    // 根级事件的构造函数
    EventTypeEnum(String code, String description) {
        this.parentCode = ""; // 根级事件没有父级编码
        this.code = code;
        this.description = description;
    }

    // 子级、孙级、重孙级事件的构造函数
    EventTypeEnum(EventTypeEnum parent, String subCode, String description) {
        System.out.println(parent);
        this.parentCode = parent.code;  // 继承父类的编码
        this.code = parent.code + subCode;               // 子类特有的编码
        this.description = description;
    }


    // 生成最终的事件代码，父类编码和子类编码拼接
    public String getEventCode() {
        return code;  // 拼接父类和子类的编码
    }

    // 获取事件描述
    public String getDescription() {
        return description;
    }

    // 测试输出所有事件
    public static void main(String[] args) {
        for (EventTypeEnum event : EventTypeEnum.values()) {
            System.out.println("事件代码: " + event.getEventCode() + ", 描述: " + event.getDescription());
        }
        //System.out.println(DEVICE_POWER_FAILURE.getEventCode());
    }
}



