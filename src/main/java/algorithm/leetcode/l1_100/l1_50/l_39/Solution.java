package algorithm.leetcode.l1_100.l1_50.l_39;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 组合总和
 ***********************************************************/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    void dfs(int[] candidates, int cur, int u) {
        if (u == candidates.length) {
            if (cur == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i <= cur / candidates[u]; i ++){
            dfs(candidates, cur - i * candidates[u], u + 1);
            path.add(candidates[u]);
        }
        for (int i = 0; i <= cur / candidates[u]; i ++){
            path.remove(path.size() - 1);
        }
    }
}