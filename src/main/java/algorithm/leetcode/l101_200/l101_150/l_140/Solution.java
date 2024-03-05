package algorithm.leetcode.l101_200.l101_150.l_140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 单词拆分 II
 ***********************************************************/
class Solution {
    Set<String> S;
    List<String> res = new ArrayList<>();

    void dfs(String s, int u, String cur) {
        if (u == s.length()) {
            res.add(cur.substring(0, cur.length() - 1));
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = u; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (S.contains(sb.toString())) {
                dfs(s, i + 1, cur + sb + " ");
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        S = new HashSet<>(wordDict);
        dfs(s, 0, "");
        return res;
    }
}