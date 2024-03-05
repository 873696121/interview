package algorithm.leetcode.l1_100.l51_100.l_78;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 子集
 ***********************************************************/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    void dfs(int[] nums, int u) {
        if(u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, u + 1);
        path.add(nums[u]);
        dfs(nums, u + 1);
        path.remove(path.size() - 1);
    }
}