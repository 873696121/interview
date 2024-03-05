package algorithm.leetcode.l1_100.l51_100.l_64;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 最小路径和
 ***********************************************************/
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                    continue;
                }
                f[i][j] = grid[i][j];
                int t = Integer.MAX_VALUE;
                if (i > 0) t = Math.min(t, f[i - 1][j]);
                if (j > 0) t = Math.min(t, f[i][j - 1]);
                f[i][j] += t;
            }
        }
        return f[n - 1][m - 1];
    }
}