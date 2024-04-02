package org.example.synchronizedMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @project container-ConcurrentHashmap
 * @description Collections的`Map<K,V> synchronizedMap(Map<K,V> m)方法使用
 * @date 2024/3/17 21:02:07
 */
public class SynchronizedMapDemo {


    public static void main(String[] args) {
        HashMap<String, Object> objectHashMap = new HashMap();
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(objectHashMap);
        //包装模式 将原来的map 包装后，每次调用都加上synchronized，保证并发安全
        /***
         * public V put(K key, V value) {
         *     synchronized (mutex) {return m.put(key, value);}
         * }
         */
        synchronizedMap.put("111","2222");


    }
}
