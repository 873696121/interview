package algorithm.leetcode.l101_200.l151_200.l_187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/6/14
 * Author: HuHong
 * Desc: 重复的DNA序列
 ***********************************************************/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> hash = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String t = s.substring(i, i + 10);
            int v = hash.getOrDefault(t, 0);
            hash.put(t, v + 1);
        }
        for (String key : hash.keySet()) {
            if (hash.get(key) > 1) {
                res.add(key);
            }
        }
        return res;
    }
}