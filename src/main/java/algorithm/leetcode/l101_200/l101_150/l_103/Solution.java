package algorithm.leetcode.l101_200.l101_150.l_103;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 二叉树的锯齿形层序遍历
 ***********************************************************/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 0;
        while (q.size() > 0) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                TreeNode t = q.poll();
                list.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            if(i % 2 == 1)  Collections.reverse(list);
            i ++;
            res.add(list);
        }
        return res;
    }
}