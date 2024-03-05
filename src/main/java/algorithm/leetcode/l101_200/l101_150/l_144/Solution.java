package algorithm.leetcode.l101_200.l101_150.l_144;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 二叉树的前序遍历
 ***********************************************************/
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}