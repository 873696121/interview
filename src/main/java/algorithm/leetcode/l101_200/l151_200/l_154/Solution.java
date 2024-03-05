package algorithm.leetcode.l101_200.l151_200.l_154;

/***********************************************************                                          *
 * Time: 2022/5/22
 * Author: HuHong
 * Desc: 寻找旋转排序数组中的最小值 II
 ***********************************************************/
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r && nums[r] == nums[0]) r--;
        if(nums[r] > nums[0]) return nums[0];
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}