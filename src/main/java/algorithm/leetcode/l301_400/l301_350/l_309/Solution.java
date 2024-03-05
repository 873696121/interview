package algorithm.leetcode.l301_400.l301_350.l_309;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 307. 区域和检索 - 数组可修改
 ***********************************************************/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 1][3];
        f[0][1] = f[0][0] = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i ++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i - 1]);
            f[i][1] = f[i - 1][0] + prices[i - 1];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n][1], f[n][2]);
    }
}