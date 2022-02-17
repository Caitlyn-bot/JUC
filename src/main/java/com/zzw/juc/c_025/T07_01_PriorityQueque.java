package com.zzw.juc.c_025;

import java.util.PriorityQueue;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T07_01_PriorityQueque {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");
        q.offer("");
        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }
}
