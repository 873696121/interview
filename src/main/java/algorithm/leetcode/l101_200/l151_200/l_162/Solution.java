package algorithm.leetcode.l101_200.l151_200.l_162;

/***********************************************************                                          *
 * Time: 2022/5/22
 * Author: HuHong
 * Desc: 寻找峰值
 ***********************************************************/
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(mid == 0 || nums[mid] >= nums[mid - 1]) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}