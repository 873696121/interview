package algorithm.leetcode.l1_100.l51_100.l_83;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for(ListNode p = dummy; p != null;){
            if(p.next != null && p.next.next != null && p.next.val == p.next.next.val) {
                int target = p.next.val;
                ListNode cur = p.next;
                while(cur.next != null && cur.next.val == target) {
                    cur.next = cur.next.next;
                }
            }else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}