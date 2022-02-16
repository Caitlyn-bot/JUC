package com.zzw.juc.c_000;


/**
 * @author 张志伟
 * @version v1.0
 */
public class T05_ThreadState {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());

            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();

        System.out.println(t.getState());

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());

    }
}
enum State{
    /**
     * 新生，刚被创建，未start
     */
    NEW,
    /**
     * 被启动后进入RUNNABLE状态运行态内部有两个状态：Ready和Running
     * Ready状态当线程被调度器选中执行，进入Running
     * Running态当线程被挂起或yield进入Ready
     */
    RUNNABLE,
    /**
     * 阻塞：等待进入同步代码块的锁
     */
    BLOCKED,
    /**
     * 等待：o.wait(),t.join(),LockSupport.park()会进入WAITING，
     * 可以被o.notify(),o.notifyAll(),LockSupport.unpark()唤醒
     */
    WAITING,
    /**
     * 超时等待：Thread.sleep(time),o.wait(time),t.join(time),LockSupport.parkNanos(),LockSupport.parkUntil()
     * 当时间结束进入RUNNABLE
     */
    TIMED_WAITING,
    /**
     * 终止：当运行完进入TERMINATED，不能够通过start方法重新进入RUNNABLE状态
     */
    TERMINATED;
}
