package algorithm.leetcode.l1_100.l1_50.l_19;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 删除链表的倒数第 N 个结点
 ***********************************************************/

/**
 *  dummy 1 2 3 4 5 null
 *         1   1 1      1
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy, q = dummy;
        for(int i = 0; i < n + 1; i ++) q = q.next;
        while(q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}