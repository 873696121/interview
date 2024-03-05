package algorithm.leetcode.l101_200.l101_150.l_141;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 环形链表
 ***********************************************************/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == null) return false;
            fast = fast.next;
            if(slow == fast) return true;
        }
        return false;
    }
}