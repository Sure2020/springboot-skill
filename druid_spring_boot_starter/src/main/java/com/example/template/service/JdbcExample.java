/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JdbcExample
 * Date Created : 2024-03-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.service;

/**
 * @program: com.example.template.service
 * @description: xxx
 * @author: w15021
 * @create: 2024-03-11
 **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

@Service
public class JdbcExample {

    /*private final DataSource dataSource;

    public JdbcExample(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
    @Autowired
    DataSource dataSource;
    private int CHECK_TIME = 5;
    private String BLOCKED_STATE = "BLOCKED";//"ACQUIRED";//"BLOCKED";

    public void fetchData() {
        System.out.println("fetchData called");

        //每次定时执行，会连续检测多次，多次检测时若每次都存在blocked的任务，则认为有任务真的阻塞了，会退出应用以触发pod重启
        int blockedTime = 0;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            for (int i = 1; i <= CHECK_TIME; i++) {
                System.out.println("当前线程名称： "+ Thread.currentThread().getName());
                System.out.println("正在检测quartz定时任务状态，次数：" + i);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM qrtz_triggers");

                while (resultSet.next()) {
                    // 处理每一行数据
                    String jobGroup = resultSet.getString("JOB_GROUP");
                    String triggerState = resultSet.getString("TRIGGER_STATE");
                    System.out.println("jobGroup: " + jobGroup + ", triggerState: " + triggerState);
                    //单次检测，遇到有blocked的任务，就表明本次检测有阻塞任务，把标记记为true，并不再分析其他任务直接break
                    if(BLOCKED_STATE.equals(triggerState)){
                        System.out.println("检测到有blocked的任务，名称： "+jobGroup);
                        blockedTime ++;
                        break;
                    }
                }
//                System.out.println("一次while循环结束，两个状态值为： " + isBlockedOneTime + "   " + isBlockedTenTimes);
//                if(!isBlockedOneTime){
//                    System.out.println("不存在连续5次都阻塞的任务，此次定时检测完成");
//                    isBlockedTenTimes=false;
//                    break;
//                }
                System.out.println("############");
                //todo 改成60秒
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("一次for循环结束，两个状态值为： " + isBlockedOneTime + "   " + isBlockedTenTimes);
        System.out.println("blockedTime: " + blockedTime);
        if(blockedTime == CHECK_TIME){
            System.out.println("本次定时检测，发现有任务一直是blocked状态，将退出应用以触发pod重启");
            System.exit(-110);
        }
        System.out.println("######################################");
    }
}
