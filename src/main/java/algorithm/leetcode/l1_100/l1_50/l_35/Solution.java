package algorithm.leetcode.l1_100.l1_50.l_35;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 搜索插入位置
 ***********************************************************/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if(nums[l] < target) l ++;
        return l;
    }
}