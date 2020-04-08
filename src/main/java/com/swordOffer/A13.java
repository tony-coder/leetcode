package com.swordOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 搜索题 DFS/BFS
 */
public class A13 {
    // 搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索
    private final static int[] dx = {1, 0};
    private final static int[] dy = {0, 1};

    public static int movingCount(int m, int n, int k) {
        int[] start = new int[]{0, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        q.add(start);
        vis[0][0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int[] node = q.peek();
            q.poll();
            ans++;
            for (int i = 0; i < 2; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && judge(x, y, k)) {
                    int[] newNode = new int[]{x, y};
                    vis[x][y] = true;
                    q.add(newNode);
                }
            }
        }
        return ans;
    }

    // 判断部分其实可以简化，因为 x<100 y<100
    private static boolean judge(int x, int y, int k) {
        int tmp = 0;
        while (x > 0) {
            tmp += x % 10;
            x /= 10;
        }
        while (y > 0) {
            tmp += y % 10;
            y /= 10;
        }
        return tmp <= k;
    }

    // DFS 这题DFS比BFS快很多
    public static int movingCount2(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return dfs(0, 0, m, n, k, visit);
    }

    private static int dfs(int i, int j, int m, int n, int k, boolean[][] visit) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || visit[i][j]) {
            return 0;
        }
        visit[i][j] = true;
        return dfs(i + 1, j, m, n, k, visit) + dfs(i, j + 1, m, n, k, visit) + 1;
    }
}