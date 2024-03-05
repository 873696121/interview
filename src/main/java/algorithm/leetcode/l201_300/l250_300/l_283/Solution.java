package algorithm.leetcode.l201_300.l250_300.l_283;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 283. 移动零
 ***********************************************************/
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0) nums[j ++] = nums[i];
        }
        while(j < nums.length) {
            nums[j] = 0;
            j ++;
        }
    }
}