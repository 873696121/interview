package algorithm.leetcode.l1_100.l51_100.l_86;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 分隔链表
 ***********************************************************/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode L = new ListNode(-1), R = new ListNode(-1);
        ListNode l = L, r = R;
        for (ListNode p = head; p != null; p = p.next) {
            if(p.val < x) l = l.next = p;
            else r = r.next = p;
        }
        l.next = r.next = null;
        getTail(L).next = R.next;
        return L.next;
    }

    ListNode getTail(ListNode head) {
        while(head != null && head.next != null) head = head.next;
        return head;
    }
}