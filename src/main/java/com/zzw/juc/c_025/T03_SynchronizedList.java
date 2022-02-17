package com.zzw.juc.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 张志伟
 * @version v1.0
 */
public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> strsSync = Collections.synchronizedList(strs);
    }
}
