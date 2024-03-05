package algorithm.leetcode.l1_100.l1_50.l_3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            cnt.put(c[i], cnt.getOrDefault(c[i], 0) + 1);
            while(j < i && cnt.get(c[i]) > 1) {
                cnt.put(c[j], cnt.get(c[j]) - 1);
                j ++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}