package algorithm.leetcode.l101_200.l101_150.l_138;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 复制带随机指针的链表
 ***********************************************************/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hash = new HashMap<>();
        for(Node p = head; p != null; p = p.next)
            hash.put(p, new Node(p.val));
        for(Node p = head; p != null; p = p.next) {
            hash.get(p).next = hash.get(p.next);
            hash.get(p).random = hash.get(p.random);
        }
        return hash.get(head);
    }
}