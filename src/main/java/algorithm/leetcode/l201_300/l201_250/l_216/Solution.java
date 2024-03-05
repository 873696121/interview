package algorithm.leetcode.l201_300.l201_250.l_216;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 216. 组合总和 III
 ***********************************************************/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, k, n);
        return res;
    }

    void dfs(int u, int k, int n) {
        // System.out.println(path);
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList(path));
            }
            return;
        }
        for (int i = u + 1; i <= 9; i++) {
            if (n >= i) {
                path.add(i);
                dfs(i, k - 1, n - i);
                path.remove(path.size() - 1);
            }
        }
    }
}