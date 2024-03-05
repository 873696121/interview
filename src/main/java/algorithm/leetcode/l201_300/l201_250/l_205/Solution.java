package algorithm.leetcode.l201_300.l201_250.l_205;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 205. 同构字符串
 ***********************************************************/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return judge(s, t);
    }

    boolean judge(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> m = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i ++){
            char a = s.charAt(i), b = t.charAt(i);
            if(m.containsKey(a) && m.get(a) != b) return false;
            m.put(a, b);
        }
        Map<Character, Boolean> st = new HashMap<>();
        for(Character k : m.keySet()) {
            Character tt = m.get(k);
            if(st.containsKey(tt)) return false;
            st.put(tt, true);
        }
        return true;
    }
}