package algorithm.leetcode.l201_300.l201_250.l_231;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 231. 2 的幂
 ***********************************************************/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(((n >> 31) & 1) == 1) return false;
        int cnt = 0;
        for(int i = 0; i < 31; i ++)
            if(((n >> i) & 1) == 1) cnt ++;
        return cnt == 1;
    }
}