package algorithm.leetcode.l1_100.l1_50.l_22;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 括号生成
 ***********************************************************/
class Solution {
    List<String> res = new ArrayList<>();
    void dfs(int l, int r, int n, String cur) {
        if(l == n && r == n) {
            res.add(cur);
            return;
        }
        if(l < n) dfs(l + 1, r, n, cur + "(");
        if(r < l) dfs(l, r + 1, n, cur + ")");
    }

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return res;
    }
}