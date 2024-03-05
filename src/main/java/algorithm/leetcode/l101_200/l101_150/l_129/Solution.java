package algorithm.leetcode.l101_200.l101_150.l_129;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 求根节点到叶节点数字之和
 ***********************************************************/
class Solution {
    int total = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    void dfs(TreeNode cur, int sum) {
        if(cur == null) return;
        sum = sum * 10 + cur.val;
        if(cur.left == null && cur.right == null) total += sum;
        if(cur.left != null) dfs(cur.left, sum);
        if(cur.right != null) dfs(cur.right, sum);
    }
}