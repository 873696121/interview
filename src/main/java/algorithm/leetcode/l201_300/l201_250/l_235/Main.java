package algorithm.leetcode.l201_300.l201_250.l_235;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 235. 二叉搜索树的最近公共祖先
 ***********************************************************/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);
        if(p.val <= root.val && q.val >= root.val) return root;
        if(p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}