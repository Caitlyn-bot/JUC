package com.zzw.juc.c_004;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T {
    private static int count = 10;

    public synchronized static void m() {
        //这里等同于synchronized(T.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized(T.class) {
            //考虑一下这里写synchronized(this)是否可以？
            count --;
        }
    }
}
