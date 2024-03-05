package algorithm.leetcode.l201_300.l201_250.l_234;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 234. 回文链表
 ***********************************************************/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        ListNode l = head, r = head;
        while(l != null && r != null) {
            l = l.next;
            r = r.next;
            if(r == null) break;
            r = r.next;
        }
        r = reverse(l);
        l = head;
        while(r != null) {
            if(l.val != r.val) return false;
            l = l.next;
            r = r.next;
        }
        return true;
    }

    void print(ListNode root) {
        for(ListNode p = root; p != null; p = p.next)
            System.out.print(p.val + " ");
        System.out.println();
    }

    ListNode reverse(ListNode root) {
        ListNode pre = null;
        for(ListNode p = root; p != null;) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}