package algorithm.leetcode.l1_100.l1_50.l_33;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 搜索旋转排序数组
 ***********************************************************/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1;
        if (nums[r] < nums[l]) {
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < nums[0]) r = mid;
                else l = mid + 1;
            }
            if (target >= nums[0]) {
                r = l - 1;
                l = 0;
            } else {
                r = n - 1;
            }
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] == target) return l;
        return -1;
    }
}