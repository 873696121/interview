package algorithm.leetcode.l201_300.l201_250.l_206;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 206. 反转链表
 ***********************************************************/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        for(ListNode p = head; p != null;) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}