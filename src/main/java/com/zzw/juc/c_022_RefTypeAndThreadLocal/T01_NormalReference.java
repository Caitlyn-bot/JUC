package com.zzw.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc(); //DisableExplicitGC

        System.in.read();
    }
}
