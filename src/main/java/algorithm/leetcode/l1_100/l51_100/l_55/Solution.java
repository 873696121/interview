package algorithm.leetcode.l1_100.l51_100.l_55;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 跳跃游戏
 ***********************************************************/
class Solution {
    public boolean canJump(int[] nums) {
        int longest = 0, step = 0, next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > longest) {
                if (i > next) return false;
                longest = next;
                step++;
            }
            next = Math.max(next, i + nums[i]);
        }
        return true;
    }
}