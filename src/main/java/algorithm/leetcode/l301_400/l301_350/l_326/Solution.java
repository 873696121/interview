package algorithm.leetcode.l301_400.l301_350.l_326;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 326. 3 的幂
 ***********************************************************/
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        while(n % 3 == 0) n /= 3;
        return n == 1;
    }
}