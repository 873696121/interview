package algorithm.leetcode.l1_100.l51_100.l_99;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 恢复二叉搜索树
 ***********************************************************/
// 1 4 3 2 5
class Solution {
    public void recoverTree(TreeNode root) {
        dfs(root);
        if(s2[0] == null) {
            int temp = s1[0].val;
            s1[0].val = s1[1].val;
            s1[1].val = temp;
        }else {
            int temp = s1[0].val;
            s1[0].val = s2[1].val;
            s2[1].val = temp;
        }
    }

    TreeNode[] s1 = new TreeNode[2];
    TreeNode[] s2 = new TreeNode[2];
    TreeNode pre = null;

    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        if(pre != null && root.val <= pre.val) {
            if(s1[0] == null) {
                s1[0] = pre;
                s1[1] = root;
            }else {
                s2[0] = pre;
                s2[1] = root;
            }
        }
        pre = root;
        dfs(root.right);
    }
}