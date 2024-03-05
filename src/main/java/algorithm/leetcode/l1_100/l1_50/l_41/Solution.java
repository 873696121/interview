package algorithm.leetcode.l1_100.l1_50.l_41;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 缺失的第一个正数
 * review
 ***********************************************************/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i ++){
            while(nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }
        for(int i = 0; i < n; i ++){
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    void swap(int[] q, int l, int r){
        int temp = q[l];
        q[l] = q[r];
        q[r] = temp;
    }
}