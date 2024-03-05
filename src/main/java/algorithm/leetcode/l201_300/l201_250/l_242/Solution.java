package algorithm.leetcode.l201_300.l201_250.l_242;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 242. 有效的字母异位词
 ***********************************************************/
class Solution {
    public boolean isAnagram(String s, String t) {
        return get(s).equals(get(t));
    }

    Map<Character, Integer> get(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            char t = s.charAt(i);
            hash.put(t, hash.getOrDefault(t, 0) + 1);
        }
        return hash;
    }
}