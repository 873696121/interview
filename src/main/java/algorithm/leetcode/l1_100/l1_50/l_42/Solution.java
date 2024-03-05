package algorithm.leetcode.l1_100.l1_50.l_42;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 接雨水
 ***********************************************************/
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] l = new int[n + 2], r = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            l[i] = Math.max(l[i - 1], height[i - 1]);
        }
        for (int i = n; i >= 1; i--) {
            r[i] = Math.max(r[i + 1], height[i - 1]);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += Math.max(0, Math.min(l[i - 1], r[i + 1]) - height[i - 1]);
        }
        return res;
    }
}
