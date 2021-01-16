package com.leetcode.medium._0947_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.HashMap;
import java.util.Map;

/**
 * 并查集
 */

public class Solution2 {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public Map<Integer, Integer> getParent() {
            return parent;
        }

        public void setParent(Map<Integer, Integer> parent) {
            this.parent = parent;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数+1
                count++;
            }
            if (x != parent.get(x))
                parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx != ry) {
                parent.put(rx, ry);
                // 两个连通分量合并成为一个，连通分量的总数 -1
                count--;
            }
        }
    }
}
