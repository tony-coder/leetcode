package com.leetcode.medium._0547_Number_of_Provinces;

/**
 * 并查集
 */
public class Solution2 {
    private int[] parent = new int[200 + 10];

    private void init(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy)
            parent[fx] = fy;
    }

    public int findCircleNum(int[][] isConnected) {
        init(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if(isConnected[i][j]==1)
                    union(i, j);
            }
        }
        int res=0;
        for (int i = 0; i < isConnected.length; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }
}
