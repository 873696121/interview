package algorithm.leetcode.l201_300.l201_250.l_220;

import java.util.TreeSet;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 220. 存在重复元素 III
 ***********************************************************/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long x = ts.ceiling((long) nums[i]);
            if (x != null && x - nums[i] <= t) return true;
            x = ts.floor((long) nums[i]);
            if (x != null && nums[i] - x <= t) return true;
            ts.add((long) nums[i]);
            if (ts.size() > k) {
                ts.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}