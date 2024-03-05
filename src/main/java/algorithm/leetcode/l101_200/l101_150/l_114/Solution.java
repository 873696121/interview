package algorithm.leetcode.l101_200.l101_150.l_114;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/5/8
 * Author: HuHong
 * Desc: 二叉树展开为链表
 ***********************************************************/
// 若当前节点有左孩子，则将左孩子的右链插入当前节点右边， 若没有左孩子则移到右孩子节点
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left != null) {
                TreeNode p = cur.left;
                while(p.right != null) p = p.right;
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }else {
                cur = cur.right;
            }
        }
    }
}
