package algorithm.leetcode.l1_100.l51_100.l_70;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 爬楼梯
 ***********************************************************/
class Solution {
    public int climbStairs(int n) {
        int[] f = new int[60];
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= n; i ++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }
}