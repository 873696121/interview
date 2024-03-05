package algorithm.leetcode.l201_300.l250_300.l_257;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 257. 二叉树的所有路径
 ***********************************************************/
class Solution {
    List<String> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    String tran(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.get(0));
        for (int i = 1; i < path.size(); i++) {
            sb.append("->").append(path.get(i));
        }
        return sb.toString();
    }

    void dfs(TreeNode root) {
        path.add(root.val);
        if (root.left == null && root.right == null) res.add(tran(path));
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
        path.remove(path.size() - 1);
    }
}