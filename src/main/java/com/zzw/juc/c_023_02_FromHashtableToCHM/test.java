package com.zzw.juc.c_023_02_FromHashtableToCHM;

import java.util.*;

/**
 * @author 张志伟
 * @version v1.0
 */
public class test {
    public static void main(String[] args) {
        HashMap<Object,Object> map = new HashMap<>();
        map.put("1","zzw");
        map.put("2","zzw2");
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(map);
        System.out.println(synchronizedMap);
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
    }
}
