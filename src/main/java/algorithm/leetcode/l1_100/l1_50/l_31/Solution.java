package algorithm.leetcode.l1_100.l1_50.l_31;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/5/11
 * Author: HuHong
 * Desc: 下一个排列
 ***********************************************************/
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        int j = n - 1;
        while (nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        Arrays.sort(nums, i + 1, n);
    }

    void swap(int[] q, int l, int r) {
        int temp = q[l];
        q[l] = q[r];
        q[r] = temp;
    }
}