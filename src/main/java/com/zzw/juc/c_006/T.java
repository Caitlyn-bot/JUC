package com.zzw.juc.c_006;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T implements Runnable {

    private int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {

        for(int i=0; i<5; i++) {
            T t = new T();
            new Thread(t, "THREAD" + i).start();
        }
    }

}
