package algorithm.leetcode.l1_100.l1_50.l_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 组合总和 II
 ***********************************************************/
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    void dfs(int[] candidates, int u, int cur) {
        if (u == candidates.length) {
            if (cur == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        int j = u + 1;
        while (j < candidates.length && candidates[j] == candidates[u]) j++;
        int cnt = j - u;
        for (int i = 0; i <= cnt && cur - i * candidates[u] >= 0; i++) {
            dfs(candidates, j, cur - i * candidates[u]);
            path.add(candidates[u]);
        }
        for (int i = 0; i <= cnt && cur - i * candidates[u] >= 0; i++) {
            path.remove(path.size() - 1);
        }
    }
}