package algorithm.leetcode.l101_200.l151_200.l_188;

/***********************************************************                                          *
 * Time: 2022/6/14
 * Author: HuHong
 * Desc: 买卖股票的最佳时机 IV
 * review
 ***********************************************************/
class Solution {
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n + 1][K + 1][2];
        for(int i = 0; i < n + 1; i ++)
            for(int j = 0; j < K + 1; j ++)
                for(int k = 0; k < 2; k ++)
                    f[i][j][k] = -0x3f3f3f3f;
        f[0][0][0] = 0;
        int res = 0;
        for(int i = 1; i <= n; i ++)
            for(int j = 0; j <= K; j ++){
                f[i][j][0] = f[i - 1][j][0];
                if(j > 0) {
                    f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j - 1][1] + prices[i - 1]);
                }
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j][0] - prices[i - 1]);
                res = Math.max(res, f[i][j][0]);
            }
        return res;
    }
}