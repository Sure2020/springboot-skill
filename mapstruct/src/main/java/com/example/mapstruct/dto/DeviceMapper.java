/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DeviceMapper
 * Date Created : 2022-09-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-09-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.mapstruct.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: com.example.mapstruct
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-13
 **/
@Mapper(componentModel = "spring")
public interface DeviceMapper {
    //DeviceMapper INSTANCE = Mappers.getMapper( DeviceMapper.class );
    @Mapping(target = "devName", source = "name")
    DeviceDTO deviceToDeviceDto(Device device);
    List<DeviceDTO> devicesToDeviceDTOs (List<Device> devices);
}