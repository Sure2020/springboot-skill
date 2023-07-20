/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : InfoSingleton
 * Date Created : 2023-05-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-05-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.util;

import lombok.Data;

/**
 * @program: com.example.test.util
 * @description: xxx
 * @author: w15021
 * @create: 2023-05-16
 **/
@Data
public class InfoSingleton {
    private Boolean isExtracting = false;
    private Boolean isExtractFailed = false;
    private Boolean isIllegalPackage = false;

    private Boolean isPlatformUpdateCompleted = false;
    private Boolean isSetPlatformUpdateStatusRunning = false;
    private Boolean isConfigInHomeEdited = true;
    /*private Boolean isUninstalling;
    private Boolean isUninstalled;
    private Boolean isInstalling;
    private Boolean isInstalled;*/
    private volatile static InfoSingleton infoSingleton;

    public  static InfoSingleton getInstance(){
        if(infoSingleton == null) {
            synchronized (InfoSingleton.class) {
                if (infoSingleton == null)
                    infoSingleton = new InfoSingleton();
            }
        }
        return infoSingleton;
    }
}