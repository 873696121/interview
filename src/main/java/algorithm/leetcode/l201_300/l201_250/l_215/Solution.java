package algorithm.leetcode.l201_300.l201_250.l_215;

/***********************************************************                                          *
 * Time: 2022/6/26
 * Author: HuHong
 * Desc: 215. 数组中的第K个最大元素
 ***********************************************************/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] q, int l, int r, int k) {
        if (l >= r) return q[l];
        int i = l - 1, j = r + 1, x = q[l];
        while(i < j) {
            while(q[++i] > x);
            while(q[--j] < x);
            if(i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        int len = j - l + 1;
        if (len >= k) return quickSelect(q, l, j, k);
        else return quickSelect(q, j + 1, r, k - len);
    }
}