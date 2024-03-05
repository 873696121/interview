package algorithm.leetcode.l101_200.l151_200.l_173;

/***********************************************************                                          *
 * Time: 2022/6/13
 * Author: HuHong
 * Desc: 二叉搜索树迭代器
 ***********************************************************/

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode root = st.pop();
        int res = root.val;
        root = root.right;
        while(root != null) {
            st.push(root);
            root = root.left;
        }
        return res;
    }

    public boolean hasNext() {
        return st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */