package algorithm.leetcode.l101_200.l101_150.l_123;

/***********************************************************                                          *
 * Time: 2022/5/9
 * Author: HuHong
 * Desc: 买卖股票的最佳时机 III
 ***********************************************************/
// 可用状态机dp，或者枚举两次交易的中间点，预处理第一次的收益，遍历第二次的起点
class Solution {
    final static int N = 100010;

    public int maxProfit(int[] prices) {
        int[][] f = new int[N][5];
        f[0][1] = f[0][2] = f[0][3] = f[0][4] = -1000000;
        int n = prices.length;
        int res = 0;
        for (int i = 1; i <= n; i++) {
             f[i][0] = f[i - 1][0];
             f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i - 1]);
             f[i][2] = Math.max(f[i - 1][2], f[i - 1][1] + prices[i - 1]);
             f[i][3] = Math.max(f[i - 1][3], f[i - 1][2] - prices[i - 1]);
             f[i][4] = Math.max(f[i - 1][4], f[i - 1][3] + prices[i - 1]);
//            System.out.println(f[i][0] + " " + f[i][1] + " " + f[i][2] + " " + f[i][3] + " " + f[i][4]);
        }
        return Math.max(f[n][0], Math.max(f[n][2], f[n][4]));
    }
}