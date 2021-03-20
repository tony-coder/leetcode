package com.leetcode.medium._0146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
 */

// 哈希表 + 双向链表
public class LRUCache {
    /*
     * 实现本题的两种操作，需要用到一个哈希表和一个双向链表。
     * 在面试中，面试官一般会期望读者能够自己实现一个简单的双向链表，而不是使用语言自带的、封装好的数据结构。
     */

    // 自实现双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    /*
        LRU 缓存机制可以通过哈希表辅以双向链表实现，我们用一个哈希表和一个双向链表维护所有在缓存中的键值对
        双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
        哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。

        这样以来，我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，随后将其移动到双向链表的头部，
        即可在 O(1) 的时间内完成 get 或者 put 操作。

     */
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int val) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // key不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, val);
            // 添加进哈希表
            cache.put(key, newNode);
            // 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 超出容量，删除双向链表的尾部节点
                DLinkedNode tmp = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tmp.key);
                size--;
            }
        } else {
            // 如果 key 存在，先通过哈希定位，再修改value，并移到头部
            node.value = val;
            moveToHead(node);
        }
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        // 无记录
        if(node==null)
            return -1;
        // 如果 key 值存在，先通过哈希表定位，再移动到头部
        moveToHead(node);
        return node.value;
    }

    // 添加到元素到双向链表头部(前插）
    private void addToHead(DLinkedNode node) {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next = node;
    }

    // 删除双向链表节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 删除尾部节点
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    // 将节点移动到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
}


/* 使用封装好的数据结构实现的代码
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
    // LinkedHashMap有一个 removeEldestEntry(Map.Entry eldest)方法，通过覆盖这个方法，加入一定的条件，满足条件返回true。当put进新的值方法返回true时，便移除该map中最老的键和值。
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

 */
