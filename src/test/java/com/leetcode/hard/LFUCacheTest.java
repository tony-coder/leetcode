package com.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class LFUCacheTest {
    @Test
    public void test() {
        LFUCache cache = new LFUCache(2 /* capacity (缓存容量) */);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        assertEquals(-1, cache.get(2));       // 返回 -1 (未找到key 2)
        assertEquals(3, cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        assertEquals(-1, cache.get(1));       // 返回 -1 (未找到 key 1)
        assertEquals(3, cache.get(3));       // 返回 3
        assertEquals(4, cache.get(4));       // 返回 4
    }

}