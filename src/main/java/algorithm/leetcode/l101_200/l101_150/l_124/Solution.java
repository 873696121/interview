package algorithm.leetcode.l101_200.l101_150.l_124;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 二叉树中的最大路径和
 ***********************************************************/
class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        ans = Math.max(ans, root.val + Math.max(0, l) + Math.max(0, r));
        return root.val + Math.max(Math.max(0, l), Math.max(0, r));
    }
}