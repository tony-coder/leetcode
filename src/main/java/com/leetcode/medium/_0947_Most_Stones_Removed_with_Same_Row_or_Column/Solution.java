package com.leetcode.medium._0947_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final int maxn = 10000;
    private boolean[] vis = new boolean[maxn];

    private void DFS(int u, List<List<Integer>> edge) {
        vis[u] = true;
        for (int t :
                edge.get(u)) {
            if (!vis[t])
                DFS(t, edge);
        }
    }

    public int removeStones(int[][] stones) {
        int len = stones.length, cnt = 0;
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            edge.add(new ArrayList<>());
            for (int j = 0; j < len; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    edge.get(i).add(j);
            }
        }
        for (int i = 0; i < len; i++) {
            if (!vis[i]) {
                DFS(i, edge);
                cnt++;
            }
        }
        return len - cnt;
    }
}

