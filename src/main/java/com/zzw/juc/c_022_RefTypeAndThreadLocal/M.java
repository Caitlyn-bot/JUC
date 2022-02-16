package com.zzw.juc.c_022_RefTypeAndThreadLocal;

/**
 * @author 张志伟
 * @version v1.0
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
