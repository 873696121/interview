package algorithm.leetcode.l101_200.l101_150.l_117;

import java.util.LinkedList;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/5/8
 * Author: HuHong
 * Desc: 填充每个节点的下一个右侧节点指针 2
 ***********************************************************/
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(q.size() > 0) {
            int len = q.size();
            Node pre = null;
            while(len -- > 0) {
                Node t = q.poll();
                if(pre != null) {
                    pre.next = t;
                }
                pre = t;
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
