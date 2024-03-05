package algorithm.leetcode.l201_300.l201_250.l_213;

/***********************************************************                                          *
 * Time: 2022/6/26
 * Author: HuHong
 * Desc: 213. 打家劫舍 II
 ***********************************************************/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[][] f = new int[n + 1][2];
        f[0][1] = Integer.MIN_VALUE;
        int res;
        f[1][1] = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i ++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i - 1];
        }
        res = Math.max(f[n][1], f[n][0]);
        f = new int[n + 1][2];
        f[0][1] = Integer.MIN_VALUE;
        f[1][0] = Integer.MIN_VALUE;
        f[1][1] = nums[0];
        for (int i = 2; i <= n; i ++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i - 1];
        }
        res = Math.max(res, f[n][0]);
        return res;
    }
}