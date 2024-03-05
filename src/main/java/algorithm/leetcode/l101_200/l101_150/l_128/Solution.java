package algorithm.leetcode.l101_200.l101_150.l_128;

import java.util.HashSet;
import java.util.Set;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 最长连续序列
 ***********************************************************/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) s.add(nums[i]);
        int res = 0;
        for(Integer t : s) {
            int l = t;
            if(!s.contains(t - 1)) {
                while(s.contains(t)) t ++;
                res = Math.max(res, t - l);
            }
        }
        return res;
    }
}