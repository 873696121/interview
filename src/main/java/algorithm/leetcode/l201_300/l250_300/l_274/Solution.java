package algorithm.leetcode.l201_300.l250_300.l_274;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 274. H 指数
 ***********************************************************/

//我们可以先将原数组从小到大排序，然后从大到小枚举 h，直到数组中后 h 个数大于等于 h 为止。
class Solution {
    // 0 1 3 5 6
    public int hIndex(int[] c) {
        Arrays.sort(c);
        for(int h = c.length; h >= 1; h --) {
            if(c[c.length - h] >= h) return h;
        }
        return 0;
    }
}