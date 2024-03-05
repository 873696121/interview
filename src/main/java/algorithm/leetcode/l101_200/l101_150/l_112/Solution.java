package algorithm.leetcode.l101_200.l101_150.l_112;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/5/7
 * Author: HuHong
 * Desc: 路径总和
 ***********************************************************/
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, root.val, targetSum);
    }

    boolean dfs(TreeNode root, int sum, int target) {
        if(root.left == null && root.right == null) {
            return sum == target;
        }
        if(root.left != null && dfs(root.left, sum + root.left.val, target)) return true;
        if(root.right != null && dfs(root.right, sum + root.right.val, target)) return true;
        return false;
    }
}
