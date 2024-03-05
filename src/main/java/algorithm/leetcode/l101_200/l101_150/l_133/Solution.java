package algorithm.leetcode.l101_200.l101_150.l_133;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 克隆图
 ***********************************************************/
class Solution {
    Map<Node, Node> hash = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        dfs(node);
        for (Node s : hash.keySet()) {
            Node d = hash.get(s);
            for(Node n : s.neighbors)
                d.neighbors.add(hash.get(n));
        }
        return hash.get(node);
    }

    void dfs(Node node) {
        hash.put(node, new Node(node.val));
        for(Node n : node.neighbors) {
            if(!hash.containsKey(n)) dfs(n);
        }
    }
}