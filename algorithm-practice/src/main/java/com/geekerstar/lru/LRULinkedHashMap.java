package com.geekerstar.lru;

import java.util.LinkedHashMap;
import java.util.Map;

//继承一下LinkedHashMap这个类，
//使用LinkedHashMap实现LRU算法
class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    //定义缓存的容量
    private int capacity;
    //带参数的构造器
    LRULinkedHashMap(int capacity) {
        //调用LinkedHashMap的构造器
        super(capacity, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    //返回true就会移除“潜水”时间最长的键值对
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //参数eldest就是“潜水”时间最长
        //的键值对，可以获得对应的
        //key,value
        return size() > capacity;
    }
}

