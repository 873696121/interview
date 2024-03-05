package algorithm.leetcode.l201_300.l250_300.l_258;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 258. 各位相加
 ***********************************************************/
class Solution {
    public int addDigits(int num) {
        while(num >= 10) {
            int t = 0;
            while(num > 0) {
                t += num % 10;
                num /= 10;
            }
            num = t;
        }
        return num;
    }
}