package algorithm.leetcode.l1_100.l1_50.l_21;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 合并两个有序链表
 ***********************************************************/
class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while(a != null && b != null) {
            if(a.val <= b.val) {
                p = p.next = a;
                a = a.next;
            }
            else {
                p = p.next = b;
                b = b.next;
            }
        }
        while(a != null) {
            p = p.next = a;
            a = a.next;
        }
        while(b != null) {
            p = p.next = b;
            b = b.next;
        }
        return dummy.next;
    }
}