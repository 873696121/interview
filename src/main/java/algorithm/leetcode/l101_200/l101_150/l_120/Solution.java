package algorithm.leetcode.l101_200.l101_150.l_120;

import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/9
 * Author: HuHong
 * Desc: 三角形最小路径和
 ***********************************************************/
class Solution {
    final static int N = 210;

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] f = new int[N][N];
        int n = triangle.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = triangle.get(i).get(j);
                if(i > 0) {
                    int t = Integer.MAX_VALUE;
                    if(j <= i - 1) t = Math.min(t, f[i - 1][j]);
                    if(j > 0) t = Math.min(t, f[i - 1][j - 1]);
                    f[i][j] += t;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++)
            res = Math.min(res, f[n - 1][i]);
        return res;
    }
}