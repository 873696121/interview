package algorithm.leetcode.l1_100.l51_100.l_69;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: x 的平方根
 ***********************************************************/
class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while(l < r){
            long mid = l + r >> 1;
            if(mid * mid >= x) r = mid;
            else l = mid + 1;
        }
        if(l * l > x) l --;
        return (int)l;
    }
}