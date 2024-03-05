package algorithm.leetcode.l1_100.l51_100.l_77;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 组合
 ***********************************************************/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    public List<List<Integer>> combine(int _n, int k) {
        n = _n;
        dfs(1, k);
        return res;
    }

    void dfs(int u, int k) {
        if(k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = u; i <= n; i ++){
            path.add(i);
            dfs(i + 1, k - 1);
            path.remove(path.size() - 1);
        }
    }
}