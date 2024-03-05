package algorithm.leetcode.l101_200.l101_150.l_113;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/7
 * Author: HuHong
 * Desc:  路径总和 II
 ***********************************************************/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        dfs(root, 0, targetSum);
        return res;
    }

    void dfs(TreeNode root, int cur, int target) {
        cur += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(cur == target) {
                res.add(new ArrayList<>(path));
            }
        }
        if(root.left != null) dfs(root.left, cur, target);
        if(root.right != null) dfs(root.right, cur, target);
        path.remove(path.size() - 1);
    }
}
