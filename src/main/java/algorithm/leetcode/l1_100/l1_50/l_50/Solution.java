package algorithm.leetcode.l1_100.l1_50.l_50;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: Pow(x, n)
 ***********************************************************/
class Solution {
    public double myPow(double x, int _n) {
        long n = _n;
        boolean flag = n < 0;
        n = Math.abs(n);
        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }
        if(flag) res = 1 / res;
        return res;
    }
}