package algorithm.leetcode.l201_300.l201_250.l_236;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 236. 二叉树的最近公共祖先
 ***********************************************************/
class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return 0;
        int state = 0;
        if(root.val == p.val) state |= 1;
        if(root.val == q.val) state |= 2;
        state |= dfs(root.left, p, q);
        state |= dfs(root.right, p, q);
        if(state == 3 && res == null) res = root;
        return state;
    }
}