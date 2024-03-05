package algorithm.leetcode.l1_100.l1_50.l_24;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 两两交换链表中的节点
 ***********************************************************/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        for(ListNode p = dummy; p != null && p.next != null && p.next.next != null;) {
            ListNode a = p.next, b = a.next, c = b.next;
            b.next = a;
            p.next = b;
            a.next = c;
            p = a;
        }
        return dummy.next;
    }
}