package com.zzw.juc.c_026_01_ThreadPool;

import java.util.concurrent.Executor;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T01_MyExecutor implements Executor {
    public static void main(String[] args) {
        new T01_MyExecutor().execute(()->System.out.println("hello executor"));
    }

    @Override
    public void execute(Runnable command) {
        //new Thread(command).run();
        command.run();

    }
}
