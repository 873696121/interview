package algorithm.leetcode.l101_200.l101_150.l_106;

import algorithm.leetcode.l1_100.l51_100.l_94.TreeNode;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/6
 * Author: HuHong
 * Desc: 从中序与后序遍历序列构造二叉树
 ***********************************************************/
public class Solution {
    Map<Integer, Integer> h = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            h.put(inorder[i], i);
        return build(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode build(int[] postorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int index = h.get(postorder[pr]);
        // pr - 1 - x = ir - index - 1
        // x = pr + index - ir
        root.left = build(postorder, inorder, pl, pr + index - ir - 1, il, index - 1);
        root.right = build(postorder, inorder, pr + index - ir, pr - 1, index + 1, ir);
        return root;
    }
}
