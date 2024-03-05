package algorithm.leetcode.l301_400.l301_350.l_328;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 328. 奇偶链表
 ***********************************************************/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode l = new ListNode(-1), r = new ListNode(-1), cl = l, cr = r;
        for(ListNode p = head; p != null;) {
            cl = cl.next = p;
            p = p.next;
            if(p != null) {
                cr = cr.next = p;
                p = p.next;
            }
        }
        cl.next = null;
        cr.next = null;
        cl.next = r.next;
        return l.next;
    }
}