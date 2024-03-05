package algorithm.leetcode.l201_300.l250_300.l_287;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 287. 寻找重复数
 ***********************************************************/
class Solution {
    public int findDuplicate(int[] nums) {
        int a = 0, b = 0;
        while(true) {
            a = nums[a];
            b = nums[nums[b]];
            if(a == b) {
                a = 0;
                while(a != b) {
                    a = nums[a];
                    b = nums[b];
                }
                return a;
            }
        }
    }
}