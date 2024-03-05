package algorithm.leetcode.l201_300.l250_300.l_290;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 290. 单词规律
 ***********************************************************/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> hash = new HashMap<>();
        Map<String, Character> hash2 = new HashMap<>();
        String[] split = s.split(" ");
        if(split.length != pattern.length()) return false;
        for(int i = 0; i < split.length; i ++) {
            // System.out.println(pattern.charAt(i) + " " + hash.get(pattern.charAt(i)));
            if(hash.containsKey(pattern.charAt(i)) && !hash.get(pattern.charAt(i)).equals(split[i])) return false;
            if(hash2.containsKey(split[i]) && !hash2.get(split[i]).equals(pattern.charAt(i))) return false;
            hash.put(pattern.charAt(i), split[i]);
            hash2.put(split[i], pattern.charAt(i));
        }
        return true;
    }
}