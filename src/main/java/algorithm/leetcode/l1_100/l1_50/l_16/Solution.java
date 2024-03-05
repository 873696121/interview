package algorithm.algorithm.leetcode.l1_100.l1_50.l_16;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 最接近的三数之和
 ***********************************************************/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, MIN = 0x3f3f3f3f;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1, k = n - 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while (j < k - 1 && nums[j] + nums[i] + nums[k - 1] >= target) k--;
                int t = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - t) < MIN) {
                    MIN = Math.abs(target - t);
                    res = t;
                }
                if (j < k - 1) {
                    t = nums[i] + nums[j] + nums[k - 1];
                    if (Math.abs(target - t) < MIN) {
                        MIN = Math.abs(target - t);
                        res = t;
                    }
                }
            }
        }
        return res;
    }
}