package algorithm.leetcode.l1_100.l51_100.l_72;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 编辑距离
 ***********************************************************/
class Solution {
    public int minDistance(String a, String b) {
        int n = a.length(), m = b.length();
        a = " " + a;
        b = " " + b;
        int[][] f = new int[n + 1][m + 1];
        for(int i = 0; i < f.length; i ++)
            Arrays.fill(f[i], 0x3f3f3f3f);
        // 注意初始化
        f[0][0] = 0;
        for(int i = 0; i <= n; i ++) f[i][0] = i;
        for(int i = 0; i <= m; i ++) f[0][i] = i;
        for (int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                if(a.charAt(i) == b.charAt(j)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                }
            }
        }
        return f[n][m];
    }
}