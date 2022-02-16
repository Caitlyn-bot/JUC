package com.zzw.juc.c_021_02_AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 张志伟
 * @version v1.0
 */
public class TestReentrantLock {
    private static volatile int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        //synchronized (TestReentrantLock.class) {
        i++;
        //}

        lock.unlock();

        //synchronized 程序员的丽春院 JUC
    }
}
