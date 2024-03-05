package algorithm.leetcode.l201_300.l250_300.l_268;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 268. 丢失的数字
 * review
 ***********************************************************/
class Solution {
    public int missingNumber(int[] nums) {
        int n =nums.length;
        int res = n;
        for(int i = 0; i < n; i ++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}