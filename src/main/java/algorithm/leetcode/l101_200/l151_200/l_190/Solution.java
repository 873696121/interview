package algorithm.leetcode.l101_200.l151_200.l_190;

/***********************************************************                                          *
 * Time: 2022/6/14
 * Author: HuHong
 * Desc: 颠倒二进制位
 ***********************************************************/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i ++) {
            res = (res << 1) + (n >> i & 1);
        }
        return res;
    }
}