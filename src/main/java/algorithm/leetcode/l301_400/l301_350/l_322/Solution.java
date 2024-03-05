package algorithm.leetcode.l301_400.l301_350.l_322;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 322. 零钱兑换
 ***********************************************************/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] f = new int[amount + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        for(int t : coins) {
            if(t <= amount) f[t] = 1;
        }
        f[0] = 0;
        for(int i = 1; i <= amount; i ++) {
            for(int t : coins) {
                if(t <= i) {
                    f[i] = Math.min(f[i], f[i - t] + 1);
                }
            }
        }
        if(f[amount] == 0x3f3f3f3f) return -1;
        return f[amount];
    }
}