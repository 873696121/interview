package algorithm.leetcode.l101_200.l101_150.l_146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class Node {
        int key, val;
        Node left, right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node L, R;
    Map<Integer, Node> hash = new HashMap<>();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        L = new Node(-1, -1);
        R = new Node(-1, -1);
        L.right = R;
        R.left = L;
    }

    void remove(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    // 向最左边插入节点, 左边为最新
    void insert(Node node) {
        node.right = L.right;
        node.left = L;
        L.right.left = node;
        L.right = node;
    }

    public int get(int key) {
        if (hash.containsKey(key)) {
            Node t = hash.get(key);
            remove(t);
            insert(t);
            return t.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 不需要插入新节点
        if (hash.containsKey(key)) {
            Node t = hash.get(key);
            t.val = value;
            remove(t);
            insert(t);
        } else {
            // 需要插入新节点
            if (hash.size() == capacity) {
                hash.remove(R.left.key);
                remove(R.left);
            }
            Node insertNode = new Node(key, value);
            hash.put(key, insertNode);
            insert(insertNode);
        }
    }
}