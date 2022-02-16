package com.zzw.juc.c_012_Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T01_HelloVolatile {
    /**
     * 对比一下有无volatile的情况下，整个程序运行结果的区别
     */
    volatile boolean running = true;
    void m() {
        System.out.println("m start");
        while(running) {
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
