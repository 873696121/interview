package algorithm.leetcode.l1_100.l51_100.l_76;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 最小覆盖子串
 * review
 ***********************************************************/
class Solution {
    Map<Character, Integer> cntS = new HashMap<>(), cntT = new HashMap<>();
    List<Character> keySet = new ArrayList<>();

    public String minWindow(String s, String t) {
        for (char c = 'a'; c <= 'z'; c++)
            keySet.add(c);
        for (char c = 'A'; c <= 'Z'; c++)
            keySet.add(c);
        for (Character c : keySet) {
            cntS.put(c, 0);
            cntT.put(c, 0);
        }
        for (int i = 0; i < t.length(); i++)
            cntT.put(t.charAt(i), cntT.get(t.charAt(i)) + 1);
        String res = s;
        boolean flag = false;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cntS.put(c, cntS.get(c) + 1);
            int k = j;
            while (j <= i && isContains()) {
                cntS.put(s.charAt(j), cntS.get(s.charAt(j)) - 1);
                j++;
            }
            if(j > k) {
                j --;
                cntS.put(s.charAt(j), cntS.get(s.charAt(j)) + 1);
            }
            if (isContains()) {
                String temp = s.substring(j, i + 1);
                if (temp.length() <= res.length()) {
                    res = temp;
                    flag = true;
                }
            }
        }
        if(!flag) return "";
        return res;
    }

    boolean isContains() {
        for (Character c : keySet) {
            if (cntS.get(c) < cntT.get(c)) return false;
        }
        return true;
    }
}