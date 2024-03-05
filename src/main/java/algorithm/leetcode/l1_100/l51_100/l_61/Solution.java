package algorithm.leetcode.l1_100.l51_100.l_61;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 旋转链表
 ***********************************************************/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int cnt = 0;
        for(ListNode p = head; p != null; p = p.next) cnt ++;
        k %= cnt;
        while(k -- > 0) head = tran(head);
        return head;
    }

    ListNode tran(ListNode head) {
        ListNode dummy = new ListNode(-1, head), p = dummy;
        while(p.next.next != null) p = p.next;
        ListNode res = new ListNode(-1, p.next);
        p.next = null;
        res.next.next = dummy.next;
        return res.next;
    }
}