package algorithm.leetcode.l101_200.l101_150.l_110;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/5/6
 * Author: HuHong
 * Desc: 平衡二叉树
 ***********************************************************/
public class Solution {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        cnt(root);
        return res;
    }

    int cnt(TreeNode root) {
        if(root == null) return 0;
        int l = cnt(root.left), r = cnt(root.right);
        if(Math.abs(l - r) > 1) res = false;
        return Math.max(l, r) + 1;
    }
}
