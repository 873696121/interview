package algorithm.leetcode.l1_100.l51_100.l_62;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 不同路径
 ***********************************************************/
class Solution {
    public int uniquePaths(int n, int m) {
        int[][] f = new int[n][m];
        f[0][0] = 1;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(i > 0) f[i][j] += f[i - 1][j];
                if(j > 0) f[i][j] += f[i][j - 1];
            }
        }
        return f[n - 1][m - 1];
    }
}