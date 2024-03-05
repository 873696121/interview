package algorithm.leetcode.l101_200.l101_150.l_135;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 分发糖果
 ***********************************************************/
// 记忆化搜索
class Solution {
    final static int N = 200010;
    int[] f = new int[N];
    int n;
    int[] ratings;

    int dp(int x) {
        if (f[x] != -1) return f[x];
        f[x] = 1;
        if (x > 0 && ratings[x - 1] < ratings[x]) f[x] = Math.max(f[x], dp(x - 1) + 1);
        if (x + 1 < n && ratings[x + 1] < ratings[x]) f[x] = Math.max(f[x], dp(x + 1) + 1);
        return f[x];
    }

    public int candy(int[] _ratings) {
        ratings = _ratings;
        n = ratings.length;
        int res = 0;
        Arrays.fill(f, -1);
        for (int i = 0; i < n; i++)
            res += dp(i);
        return res;
    }
}