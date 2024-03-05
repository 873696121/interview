package algorithm.leetcode.l201_300.l201_250.l_230;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 230. 二叉搜索树中第K小的元素
 ***********************************************************/
class Solution {
    int res = 0;
    int k;
    public int kthSmallest(TreeNode root, int _k) {
        k = _k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        k --;
        if(k == 0) {
            res = root.val;
            return;
        }
        dfs(root.right);
    }
}