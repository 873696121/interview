package algorithm.leetcode.l1_100.l1_50.l_1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(target - nums[i])) {
                return new int[]{i, h.get(target - nums[i])};
            }
            h.put(nums[i], i);
        }
        return null;
    }
}
