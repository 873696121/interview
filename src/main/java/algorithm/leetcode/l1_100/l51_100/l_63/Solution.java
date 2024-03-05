package algorithm.leetcode.l1_100.l51_100.l_63;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 不同路径 II
 ***********************************************************/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] f = new int[n][m];
        f[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i > 0) f[i][j] += f[i - 1][j];
                    if (j > 0) f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[n - 1][m - 1];
    }
}