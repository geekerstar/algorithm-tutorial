package com.geekerstar.lru;

import java.util.HashMap;

class LRUCache {
    //“潜水”链表节点，抽象
    static class Node {
        //键值对
        private int key;
        private int value;
        //维护“潜水”键值对，双向链表
        private Node pre;
        private Node next;

        //构造器
        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //指定的容量
    private int cap;
    //保留“潜水”双向链表的头尾指针
    private Node head;
    private Node tail;
    //保存键值对的map
    private HashMap<Integer, Node> map;

    //构造器参数是：指定的容量
    public LRUCache(int capacity) {
        this.cap = capacity;
    //初始化头尾节点，这里的头结点是
    //辅助节点
    //head节点不存储任何有效元素
        head = new Node();
        tail = head;
    //构造器初试容量这样设置可以保证map
    //不会发生扩容，详见之前的HashMap
    //讲解文章
        map = new HashMap<>((int) (cap / 0.75) + 1);
    }

    //将指定节点从链表中删除
    private void removeNode(Node cur) {
        if (cur == tail) {
            tail = tail.pre;

            tail.next = null;
            cur.pre = null;
        } else {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;

            cur.pre = null;
            cur.next = null;
        }
    }

    //将指定节点追加到链表末尾
    private void add(Node cur) {
        tail.next = cur;
        cur.pre = tail;

        tail = cur;
    }

    //访问一个键值对
    public int get(int key) {
        Node cur = map.get(key);
        //不存在这个key
        if (cur == null) {
            return -1;
        } else {//存在
            //含义是当前潜水节点已经被访问了
            //将这个节点添加到链表末尾
            removeNode(cur);
            add(cur);

            return cur.value;
        }
    }

    //存储一个键值对
    public void put(int key, int value) {
        Node cur = map.get(key);

        if (cur == null) {
            //put前不存在这个key
            cur = new Node(key, value);

            //将该键值对移动到链表末尾
            map.put(key, cur);
            add(cur);

            //超出了容量，移除链表头结点
            //后面那个元素(头结点是辅助节点)
            if (map.size() > cap && head != tail) {
                Node outDate = head.next;
                removeNode(outDate);
                //不能忘记这里map.remove(outDate.key);
            }
        } else {
            //put之前已经存在
            //将这个键值对移到链表末尾即可
            removeNode(cur);
            add(cur);
            //更新这个key的值
            cur.value = value;
        }
    }
}

