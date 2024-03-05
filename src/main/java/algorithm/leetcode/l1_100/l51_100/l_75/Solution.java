package algorithm.leetcode.l1_100.l51_100.l_75;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 颜色分类
 * review
 ***********************************************************/
class Solution {
    /**
     *       0  j-1 j i-1 i k-1 k
     *       0->j-1  0
     *       j->i-1  1
     *       i->k-1  未知
     *       k->end  2
     * @param nums
     */
    public void sortColors(int[] nums) {
        for (int n = nums.length, i = 0, j = 0, k = n - 1; i < k; ) {
            if (nums[i] == 0) swap(nums, j++, i++);
            else if (nums[i] == 1) i++;
            else swap(nums, i, k--);
        }
    }

    void swap(int[] q, int l, int r) {
        int temp = q[l];
        q[l] = q[r];
        q[r] = temp;
    }
}