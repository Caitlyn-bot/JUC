package com.zzw.juc.c_026_00_interview;

import java.util.concurrent.locks.LockSupport;

/**
 * 要求用线程顺序打印A1B2C3....Z26
 * @author 张志伟
 * @version v1.0
 */
public class T02_00_LockSupport {
    static Thread t1 = null, t2 = null;
    public static void main(String[] args) {
        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();
        t1 = new Thread(()->{
            for (char c : aI) {
                System.out.print(c);
                //唤醒t2
                LockSupport.unpark(t2);
                //阻塞自己
                LockSupport.park();
            }
            LockSupport.unpark(t2);
        },"t1");
        t2 = new Thread(()->{
            for (char c : aC) {
                //阻塞自己
                LockSupport.park();
                System.out.println(c);
                //唤醒t1
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
