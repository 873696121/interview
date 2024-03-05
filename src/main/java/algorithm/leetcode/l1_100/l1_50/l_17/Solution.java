package algorithm.leetcode.l1_100.l1_50.l_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 电话号码的字母组合
 ***********************************************************/
public class Solution {
    Map<Integer, String> m = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        m.put(2, "abc");
        m.put(3, "def");
        m.put(4, "ghi");
        m.put(5, "jkl");
        m.put(6, "mno");
        m.put(7, "pqrs");
        m.put(8, "tuv");
        m.put(9, "wxyz");
        dfs(digits, 0, new StringBuffer());
        return res;
    }

    void dfs(String digits, int u, StringBuffer sb) {
        if (u == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String t = m.get(digits.charAt(u) - '0');
        for (int i = 0; i < t.length(); i++) {
            sb.append(t.charAt(i));
            dfs(digits, u + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
