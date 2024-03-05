package algorithm.leetcode.l1_100.l1_50.l_27;

/***********************************************************                                          *
 * Time: 2022/5/5
 * Author: HuHong
 * Desc: 移除元素
 * KMP
 ***********************************************************/

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != val) nums[j ++] = nums[i];
        }
        return j;
    }
}