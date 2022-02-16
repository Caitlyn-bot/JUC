package com.zzw.juc.c_000;

/**
 * 测试Object的wait和notify
 * @author 张志伟
 * @version v1.0
 */
public class T04_ObjectWaitNotify {
    /**
     * 对象
     */
    private static final Object obj = new Object();

    /**
     * wait 方法是属于 Object 类中的，
     * wait 过程中线程会释放对象锁，
     * 只有当其他线程调用 notify 才能唤醒此线程。
     * wait 使用时必须先获取对象锁，
     * 即必须在 synchronized 修饰的代码块中使用，
     * 那么相应的 notify 方法同样必须在 synchronized 修饰的代码块中使用，
     * 如果没有在synchronized 修饰的代码块中使用时运行时,
     * 会抛出IllegalMonitorStateException的异常
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread1());
        Thread t2 = new Thread(new MyThread2());
        t1.start();
        t2.start();
    }

    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread1 start");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 end");
            }
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread2 start");
                obj.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 end");
            }
        }
    }

}
