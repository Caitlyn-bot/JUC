package com.zzw.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T08_SynchronusQueue {//容量为0
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        strs.put("aaa"); //阻塞等待消费者消费
        //strs.put("bbb");
        //strs.add("aaa");
        System.out.println(strs.size());
    }
}
