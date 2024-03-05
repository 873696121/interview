package algorithm.leetcode.l1_100.l1_50.l_45;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 跳跃游戏 II
 ***********************************************************/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int longest = 0, step = 0, next = nums[0];
        for(int i = 0; i < n; i ++){
            if(i > longest) {
                longest = next;
                step ++;
            }
            next = Math.max(next, i + nums[i]);
        }
        return step;
    }
}