package algorithm.leetcode.l101_200.l151_200.l_160;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/22
 * Author: HuHong
 * Desc: 相交链表
 ***********************************************************/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        while(p != q) {
            if(p == null) p = headB;
            else p = p.next;
            if(q == null) q = headA;
            else q = q.next;
        }
        return p;
    }
}