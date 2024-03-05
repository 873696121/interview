package algorithm.leetcode.l1_100.l51_100.l_59;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 螺旋矩阵 II
 ***********************************************************/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] g = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, i = 0;
        for (int k = 1; k <= n * n; k++) {
            g[x][y] = k;
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                i = (i + 1) % 4;
                x += dx[i];
                y += dy[i];
            }
        }
        return g;
    }
}