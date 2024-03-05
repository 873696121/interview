package algorithm.leetcode.l101_200.l101_150.l_148;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 排序链表
 * review
 ***********************************************************/
class Solution {

    // 归并排序
    // todo
    public ListNode sortList(ListNode head) {
        return null;
    }

    // 单链表快速排序(超时)
    public ListNode quickSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left = new ListNode(-1);
        ListNode mid = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode lt = left, mt = mid, rt = right;
        int target = head.val;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < target) {
                lt.next = p;
                lt = lt.next;
            } else if (p.val == target) {
                mt.next = p;
                mt = mt.next;
            } else {
                rt.next = p;
                rt = rt.next;
            }
        }
        lt.next = mt.next = rt.next = null;
        left.next = quickSortList(left.next);
        right.next = quickSortList(right.next);
        getTail(left).next = mid.next;
        getTail(left).next = right.next;
        return left.next;
    }

    ListNode getTail(ListNode head) {
        while (head != null && head.next != null) head = head.next;
        return head;
    }
}