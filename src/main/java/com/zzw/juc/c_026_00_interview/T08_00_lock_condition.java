package com.zzw.juc.c_026_00_interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 要求用线程顺序打印A1B2C3....Z26
 * @author 张志伟
 * @version v1.0
 */
public class T08_00_lock_condition {
    public static void main(String[] args) {
        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                for (char c : aI) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.println(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
