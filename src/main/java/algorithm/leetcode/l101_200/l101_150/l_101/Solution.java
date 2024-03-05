package algorithm.leetcode.l101_200.l101_150.l_101;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 对称二叉树
 ***********************************************************/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    boolean isSymmetric(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null || a.val != b.val) return false;
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}