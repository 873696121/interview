package algorithm.leetcode.l101_200.l151_200.l_198;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 198. 打家劫舍
 ***********************************************************/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 1][2];
        f[0][1] = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i ++){
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i - 1];
        }
        return Math.max(f[n][0], f[n][1]);
    }
}