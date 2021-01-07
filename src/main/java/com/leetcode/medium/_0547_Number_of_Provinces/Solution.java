package com.leetcode.medium._0547_Number_of_Provinces;

/**
 * 深度优先搜索
 */
public class Solution {
    private boolean[] vis = new boolean[200 + 10];

    private void DFS(int[][] isConnected, int u) {
        vis[u] = true;
        for (int i = 0; i < isConnected[u].length; i++) {
            if (isConnected[u][i] == 1 && !vis[i])
                DFS(isConnected, i);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                res++;
                DFS(isConnected, i);
            }
        }
        return res;
    }
}
