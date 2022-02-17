package com.zzw.juc.c_023_01_Containers;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 张志伟
 * @version v1.0
 */
public class HelloQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayBlockingQueue<>(2);
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);


    }
}
