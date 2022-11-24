/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Bank
 * Date Created : 2022-11-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-11-18       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.chapter14_1.code14_5;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @program: com.example.template.chapter14_1.chapter14_5
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-18
 **/
/**
 * A bank with a number of bank accounts.
 * ©version 1.30 2004-08-01
 * ©author Cay Horstmann
 */
public class Bank
{
    private Lock bankLock = new ReentrantLock();// ReentrantLock implements the Lock interface
    private final double[] accounts;
/* Constructs the bank.
* @param n the number of accounts
* @param initialBalance the initial balance for each account
    */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }
/**
 * Transfers money from one account to another.
 * @param from the account to transfer from
 * @param to the account to transfer to
 * @param amount the amount to transfer
*/
public void transfer(int from, int to, double amount) {
    bankLock.lock();
    try {
        if (accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        bankLock.unlock();
    }
}

/**
 * Gets the sun of all account balances.
 * ©return the total balance
 */
public double getTotalBalance()

    {
        double sum = 0;
        for (double a: accounts)
            sum += a;
        return sum;
    }
/**
 * Gets the number of accounts in the bank.
 * ©return the number of accounts
 */
public int size(){
return accounts.length;
}
}