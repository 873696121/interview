package algorithm.leetcode.l1_100.l1_50.l_23;

import algorithm.leetcode.l1_100.l1_50.l_2.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 合并K个升序链表
 ***********************************************************/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode dummy = new ListNode(-1), p = dummy;
        Queue<ListNode> q = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for(int i = 0; i < lists.length; i ++)
            if(lists[i] != null) q.offer(lists[i]);
        while(q.size() > 0) {
            ListNode t = q.poll();
            p = p.next = t;
            if(t.next != null) q.offer(t.next);
        }
        return dummy.next;
    }
}