package algorithm.leetcode.l1_100.l1_50.l_34;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 在排序数组中查找元素的第一个和最后一个位置
 ***********************************************************/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1;
        if(n == 0) {
            return new int[]{-1, -1};
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[]{-1, -1};
        int L = l;
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{L, l};
    }
}