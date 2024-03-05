package algorithm.leetcode.l101_200.l151_200.l_199;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 199. 二叉树的右视图
 ***********************************************************/

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class Solution {
    public List<Integer> rightSideView(TreeNode r) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(r);
        List<Integer> res = new ArrayList<>();
        if(r == null) return res;
        while(q.size() > 0) {
            int len = q.size();
            while(len -- > 0) {
                TreeNode root = q.poll();
                if(len == 0) {
                    res.add(root.val);
                }
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer t = new Integer(1);
        add(t);
        System.out.println(t);
    }

    static void add(Integer a) {
        a ++;
    }
}