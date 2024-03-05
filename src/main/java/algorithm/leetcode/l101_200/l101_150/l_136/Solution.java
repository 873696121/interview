package algorithm.leetcode.l101_200.l101_150.l_136;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 只出现一次的数字
 ***********************************************************/
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i ++)
            res ^= nums[i];
        return res;
    }
}