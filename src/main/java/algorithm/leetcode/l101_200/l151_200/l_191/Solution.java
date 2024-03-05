package algorithm.leetcode.l101_200.l151_200.l_191;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 位1的个数
 ***********************************************************/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i < 32; i ++) {
            res += (n >> i) & 1;
        }
        return res;
    }
}