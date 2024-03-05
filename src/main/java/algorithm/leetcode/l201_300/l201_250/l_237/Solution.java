package algorithm.leetcode.l201_300.l201_250.l_237;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 237. 删除链表中的节点
 ***********************************************************/
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        if(node.next == null) node = null;
        else {
            ListNode n = node.next;
            node.next = node.next.next;
            node.val = n.val;
        }
    }
}