package algorithm.leetcode.l101_200.l101_150.l_121;

/***********************************************************                                          *
 * Time: 2022/5/9
 * Author: HuHong
 * Desc: 买卖股票的最佳时机
 ***********************************************************/
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, pre = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i ++){
            res = Math.max(res, prices[i] - pre);
            pre = Math.min(pre, prices[i]);
        }
        return res;
    }
}