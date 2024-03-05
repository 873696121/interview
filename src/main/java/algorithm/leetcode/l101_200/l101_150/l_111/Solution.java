package algorithm.leetcode.l101_200.l101_150.l_111;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/5/6
 * Author: HuHong
 * Desc: 二叉树的最小深度
 ***********************************************************/
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while(q.size() > 0) {
            res ++;
            int len = q.size();
            while(len -- > 0) {
                TreeNode t = q.poll();
                if(t.left == null && t.right == null) return res;
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
        }
        return res;
    }
}
