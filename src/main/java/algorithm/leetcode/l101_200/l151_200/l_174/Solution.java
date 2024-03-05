package algorithm.leetcode.l101_200.l151_200.l_174;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/6/14
 * Author: HuHong
 * Desc: 地下城游戏
 * Tag: DP
 * review
 ***********************************************************/
class Solution {
    public int calculateMinimumHP(int[][] w) {
        int n = w.length, m = w[0].length;
        int[][] f = new int[n + 1][m + 1];
        for(int i = 0; i < n; i ++)
            Arrays.fill(f[i], 0x3f3f3f3f);
        for (int i = n - 1; i >= 0; i --) {
            for (int j = m - 1; j >= 0; j --) {
                if(i == n - 1 && j == m - 1) {
                    f[i][j] = Math.max(1 - w[i][j], 1);
                } else {
                    if(i + 1 < n) {
                        f[i][j] = Math.min(f[i][j], f[i + 1][j] - w[i][j]);
                    }
                    if (j + 1 < m) {
                        f[i][j] = Math.min(f[i][j], f[i][j + 1] - w[i][j]);
                    }
                    f[i][j] = Math.max(f[i][j], 1);
                }
            }
        }
        return f[0][0];
    }
}