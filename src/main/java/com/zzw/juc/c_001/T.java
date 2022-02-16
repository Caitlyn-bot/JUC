package com.zzw.juc.c_001;


/**
 * synchronized关键字
 * 对某个对象加锁
 * @author 张志伟
 * @version v1.0
 */
public class T {
    private int count = 10;
    private Object o = new Object();
    public void m(){
        synchronized(o){
            //任何线程要执行下面的代码，必须先拿到对象o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count" + count);
        }
    }
}
