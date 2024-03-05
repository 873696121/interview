package algorithm.leetcode.l101_200.l151_200.l_172;

/***********************************************************                                          *
 * Time: 2022/6/13
 * Author: HuHong
 * Desc: 阶乘后的零
 ***********************************************************/
class Solution {
    public int trailingZeroes(int n) {
        int cnt2 = 0, cnt5 = 0;
        for(int i = 2; i <= n; i ++){
            int x = i;
            while(x % 2 == 0) {
                cnt2 ++;
                x /= 2;
            }
            while(x % 5 == 0) {
                cnt5 ++;
                x /= 5;
            }
        }
        return Math.min(cnt2, cnt5);
    }
}