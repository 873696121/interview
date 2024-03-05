package algorithm.leetcode.l101_200.l101_150.l_122;

/***********************************************************                                          *
 * Time: 2022/5/9
 * Author: HuHong
 * Desc: 买卖股票的最佳时机 II
 ***********************************************************/
class Solution {
    final static int N = 30010;
    public int maxProfit(int[] prices) {
        int[][] f = new int[N][2];
        f[0][1] = Integer.MIN_VALUE;
        int n = prices.length;
        for(int i = 1; i <= n; i ++){
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i - 1]);
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i - 1]);
        }
        return f[n][0];
    }
}