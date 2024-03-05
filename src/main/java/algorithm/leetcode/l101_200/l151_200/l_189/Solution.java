package algorithm.leetcode.l101_200.l151_200.l_189;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/6/14
 * Author: HuHong
 * Desc: 轮转数组
 ***********************************************************/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    void reverse(int[] nums, int l, int r) {
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l ++;
            r --;
        }
    }
}