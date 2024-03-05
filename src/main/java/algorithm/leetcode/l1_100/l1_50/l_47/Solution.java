package algorithm.leetcode.l1_100.l1_50.l_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 全排列 II
 ***********************************************************/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] st = new boolean[12];
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    void dfs(int[] nums, int u) {
        if(u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length;  i++){
            if(i > 0 && nums[i] == nums[i - 1] && !st[i - 1]) continue;
            if(!st[i]) {
                st[i] = true;
                path.add(nums[i]);
                dfs(nums, u + 1);
                path.remove(path.size() - 1);
                st[i] = false;
            }
        }
    }
}