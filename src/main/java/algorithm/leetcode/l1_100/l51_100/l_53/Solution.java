package algorithm.leetcode.l1_100.l51_100.l_53;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 最大子数组和
 ***********************************************************/
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i - 1] > 0) nums[i] += nums[i - 1];
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}