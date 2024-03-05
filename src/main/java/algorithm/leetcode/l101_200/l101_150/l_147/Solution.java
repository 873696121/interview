package algorithm.leetcode.l101_200.l101_150.l_147;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 对链表进行插入排序
 ***********************************************************/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        int cnt = 0;
        for(ListNode p = head; p != null; p = p.next) cnt ++;
        ListNode res = new ListNode(-1);
        ListNode p;
        for(p = res; cnt -- > 0; p = p.next) {
            int MIN = 0x3f3f3f3f;
            ListNode minNode = null;
            for(ListNode q = dummy; q.next != null; q = q.next) {
                if(q.next.val < MIN) {
                    MIN = q.next.val;
                    minNode = q;
                }
            }
            p.next = minNode.next;
            minNode.next = minNode.next.next;
        }
        p.next = null;
        return res.next;
    }
}