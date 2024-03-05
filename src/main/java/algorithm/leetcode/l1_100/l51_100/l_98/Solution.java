package algorithm.leetcode.l1_100.l51_100.l_98;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 验证二叉搜索树
 ***********************************************************/
class Solution {
    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        dfs(root);
        return res;
    }

    // max min
    int[] dfs(TreeNode root) {
        int[] cur = new int[]{root.val, root.val};
        if(root.left != null) {
            int[] l = dfs(root.left);
            if(root.val <= l[0]) res = false;
            cur[0] = Math.max(cur[0], l[0]);
            cur[1] = Math.min(cur[1], l[1]);
        }
        if(root.right != null) {
            int[] r = dfs(root.right);
            if(root.val >= r[1]) res = false;
            cur[0] = Math.max(cur[0], r[0]);
            cur[1] = Math.min(cur[1], r[1]);
        }
        return cur;
    }
}