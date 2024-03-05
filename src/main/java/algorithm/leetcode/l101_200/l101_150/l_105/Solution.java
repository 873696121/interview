package algorithm.leetcode.l101_200.l101_150.l_105;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/6
 * Author: HuHong
 * Desc: 从前序与中序遍历序列构造二叉树
 ***********************************************************/
public class Solution {
    Map<Integer, Integer> h = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i ++)
            h.put(inorder[i], i);
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int index = h.get(preorder[pl]);
        // x - pl - 1 = index - 1 - il
        // x = pl + index  - il
        root.left = build(preorder, inorder, pl + 1, pl + index - il, il, index - 1);
        root.right = build(preorder, inorder, pl + index - il + 1, pr, index + 1, ir);
        return root;
    }
}
