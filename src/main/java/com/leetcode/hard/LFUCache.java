package com.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU缓存
 * https://leetcode-cn.com/problems/lfu-cache/
 * 哈希表+双向链表
 * O(1)
 * HashMap<Integer, Node> cache 存缓存的内容; min 是最小访问频次;
 * HashMap<Integer, LinkedHashSet<Node>> freqMap 存每个访问频次对应的 Node 的双向链表
 * （写法 1 为了方便，直接用了 JDK 现有的 LinkedHashSet，其实现了 1 条双向链表贯穿哈希表中的所有 Entry，
 * 支持以插入的先后顺序对原本无序的 HashSet 进行迭代）
 */
public class LFUCache {
    public Map<Integer, Node> cache;  // 储存缓存的内容
    private Map<Integer, LinkedHashSet<Node>> freqMap;  // 存储每个频次对应的双向链表
    private int size;  // 当前缓存大小
    private int capacity;  // 容量
    private int min;  // 储存当前最小频次

    public LFUCache(int capacity) {
        size = 0;
        min = 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        freqInc(node);  // 这个缓存的使用频率加一，需要更新缓存在哈希表 freqMap 中的位置
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);  // 增加频次
        } else {
            if (size == capacity) {  // 缓存已满
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    // 从原freq对应的链表里移除, 并更新min
    void freqInc(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    // 新插入节点
    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}