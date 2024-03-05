package algorithm.leetcode.l1_100.l51_100.l_92;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         ListNode p = dummy;
         for(int i = 0; i < left - 1; i ++) p = p.next;
         ListNode a = p.next, b = a.next;
         for(int i = 0; i < right - left; i ++){
             ListNode c = b.next;
             b.next = a;
             a = b;
             b = c;
         }
         ListNode next = p.next;
         p.next = a;
         next.next = b;
         return dummy.next;
    }
}