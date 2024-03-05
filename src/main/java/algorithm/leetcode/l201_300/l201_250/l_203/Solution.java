package algorithm.leetcode.l201_300.l201_250.l_203;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 203. 移除链表元素
 ***********************************************************/

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1, head);
        for(ListNode p = dummy; p != null && p.next != null;) {
            if(p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }
        return dummy.next;
    }
}