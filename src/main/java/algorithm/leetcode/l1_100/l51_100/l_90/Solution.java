package algorithm.leetcode.l1_100.l51_100.l_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int u) {
        if(u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        int j = u;
        while(j < nums.length && nums[j] == nums[u]) j ++;
        for(int i = 0; i <= j - u; i ++){
            dfs(nums, j);
            path.add(nums[u]);
        }
        for(int i = 0; i <= j - u; i ++){
            path.remove(path.size() - 1);
        }
    }
}