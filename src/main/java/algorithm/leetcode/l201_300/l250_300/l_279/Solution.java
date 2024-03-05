package algorithm.leetcode.l201_300.l250_300.l_279;

/***********************************************************                                          *
 * Time: 2022/7/1
 * Author: HuHong
 * Desc: 279. 完全平方数
 * review
 ***********************************************************/
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 10];
        for(int i = 1; i <= n; i ++) {
            f[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j ++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}