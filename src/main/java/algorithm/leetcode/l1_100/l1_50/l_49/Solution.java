package algorithm.leetcode.l1_100.l1_50.l_49;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 字母异位词分组
 ***********************************************************/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String t = new String(c);
            if (!hash.containsKey(t))
                hash.put(t, new ArrayList<>());
            hash.get(new String(c)).add(str);
        }
        for (String s : hash.keySet()) {
            res.add(hash.get(s));
        }
        return res;
    }
}