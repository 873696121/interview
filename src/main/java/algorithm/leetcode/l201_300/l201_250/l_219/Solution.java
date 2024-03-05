package algorithm.leetcode.l201_300.l201_250.l_219;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 219. 存在重复元素 II
 ***********************************************************/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i]) && i - hash.get(nums[i]) <= k) return true;
            hash.put(nums[i], i);
        }
        return false;
    }
}