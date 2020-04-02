package com.leetcode.medium;

/**
 * 289. 生命游戏
 * https://leetcode-cn.com/problems/game-of-life/
 * 利用多余的比特位存储状态
 * 原有的最低位存储的是当前状态，那倒数第二低位存储下一个状态就行了。
 */
public class Game_of_Life {
    private static final int[] DX = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] DY = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + DX[k];
                    int y = j + DY[k];
                    if (x < 0 || x >= n || y < 0 || y >= m)
                        continue;
                    // 这里不能直接加board[x][y]，因为 board[x][y] 的倒数第二位是可能有值的
                    cnt += board[x][y] & 1;
                }
                if ((board[i][j] & 1) > 0) {
                    if (cnt >= 2 && cnt <= 3) {
                        // 周围有2/3个活细胞，下一个状态还是活细胞
                        board[i][j] = 0b11;  // 二进制
                    }
                    // 周围活细胞过多或过少都会死，因为原数据是0b01，所以这里不用额外赋值
                } else if (cnt == 3) {
                    // 这个是死细胞，周围有3个活细胞，下一个状态变为活细胞
                    board[i][j] = 0b10;
                }
            }
        }
        // 最后一位去掉，倒数第二位变为更新后的状态
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
