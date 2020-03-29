package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class As_Far_from_Land_as_Possible {
    public static int runSolution(int[][] grid) {
        Solution solution = new Solution();
        return solution.maxDistance(grid);
    }
}

class Solution {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    public int maxDistance(int[][] grid) {
        int ans = -1, n = grid.length, m = grid[0].length;
        Queue<node> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = true;
                    queue.add(new node(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            node cur = queue.peek();
            queue.poll();
            ans = Math.max(ans, cur.level);
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
                    vis[x][y] = true;
                    queue.add(new node(x, y, cur.level + 1));
                }
            }
        }
        return ans == 0 ? -1 : ans;
    }
}

class node {
    int x, y, level;

    node(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}