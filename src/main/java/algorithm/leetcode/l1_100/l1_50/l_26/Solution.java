package algorithm.leetcode.l1_100.l1_50.l_26;

/***********************************************************                                          *
 * Time: 2022/5/5
 * Author: HuHong
 * Desc: 删除有序数组中的重复项
 ***********************************************************/
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[j ++] = nums[i];
            }
        }
        return j;
    }
}
