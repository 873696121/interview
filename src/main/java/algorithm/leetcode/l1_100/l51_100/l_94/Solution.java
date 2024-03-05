package algorithm.leetcode.l1_100.l51_100.l_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树非递归中序遍历
 * review
 */

class Solution {
    List<Integer> res = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        dfs(root);
//        return res;
//    }

    // 非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || st.size() > 0) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}