package algorithm.leetcode.l201_300.l250_300.l_297;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 297. 二叉树的序列化与反序列化
 ***********************************************************/

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode _root) {
        if(_root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(_root);
        while(q.size() > 0) {
            int len = q.size();
            while(len -- > 0) {
                TreeNode root = q.poll();
                if(root == null) sb.append(" # ");
                else {
                    sb.append(root.val).append(" ");
                    q.offer(root.left);
                    q.offer(root.right);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;
        String[] split = data.split("\\s+");
        if(split.length == 1) return null;
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        int i = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size() > 0) {
            TreeNode cur = q.poll();
            if(!split[i].equals("#")) {
                cur.left = new TreeNode(Integer.valueOf(split[i]));
                q.offer(cur.left);
            }
            i ++;
            if(!split[i].equals("#")) {
                cur.right = new TreeNode(Integer.valueOf(split[i]));
                q.offer(cur.right);
            }
            i ++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));