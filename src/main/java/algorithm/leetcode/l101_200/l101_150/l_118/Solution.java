package algorithm.leetcode.l101_200.l101_150.l_118;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/8
 * Author: HuHong
 * Desc: 杨辉三角
 ***********************************************************/
class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] f = new int[n][n];
        f[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) f[i][j] += f[i - 1][j - 1];
                f[i][j] += f[i - 1][j];
            }
        }
        for(int i = 0; i < n; i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j ++){
                list.add(f[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}