/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2023-08-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.prototest;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: com.example.prototest
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-01
 **/
public class TestMain {
    public static void main(String[] args) {
        int id = new Random().nextInt();
        String name = "Test";
        String email = "test@example.org";
        String number = "01234567890";
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                .setId(id)
                .setName(name)
                .setEmail(email)
                .addNumbers(number)
                .build();
        //序列化
        byte[] bytes = person.toByteArray();
        System.out.println("序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //反序列化
        try {
            AddressBookProtos.Person parseFrom = AddressBookProtos.Person.parseFrom(bytes);
            System.out.println("还原后的数据="+parseFrom);
            System.out.println("还原后的数据="+parseFrom.getName());
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
        System.out.println("##########################");
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
                .addPeople(person)
                .build();
        System.out.println(addressBook);
        byte[] bytesAddressBook = addressBook.toByteArray();
        //序列化
        System.out.println("序列化后的数据：" + Arrays.toString(bytesAddressBook)+",字节个数："+bytesAddressBook.length);
        //反序列化
        try {
            AddressBookProtos.AddressBook parseFromAddressBook = AddressBookProtos.AddressBook.parseFrom(bytesAddressBook);
            System.out.println("还原后的数据="+parseFromAddressBook);
            System.out.println("还原后的数据="+parseFromAddressBook.getPeople(0).getEmail());
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }
}