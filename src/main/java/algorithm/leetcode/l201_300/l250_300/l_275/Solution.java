package algorithm.leetcode.l201_300.l250_300.l_275;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 275. H 指数 II
 ***********************************************************/
class Solution {
    public int hIndex(int[] c) {
        int n = c.length;
        int l = 1, r = n;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(c[c.length - mid] >= mid) l = mid;
            else r = mid - 1;
        }
        if(c[c.length - l] < l) return 0;
        return l;
    }
}