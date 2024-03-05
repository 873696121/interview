package algorithm.leetcode.l1_100.l1_50.l_25;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/5
 * Author: HuHong
 * Desc: K 个一组翻转链表
 ***********************************************************/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        for (ListNode p = dummy; ; ) {
            ListNode q = p;
            for (int i = 0; i < k && q != null; i++) q = q.next;
            if (q == null) break;
            ListNode a = p.next, b = a.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
            ListNode next = p.next;
            p.next = a;
            next.next = b;
            p = next;
        }
        return dummy.next;
    }
}