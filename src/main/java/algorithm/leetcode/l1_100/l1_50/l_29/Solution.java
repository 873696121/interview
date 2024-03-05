package algorithm.leetcode.l1_100.l1_50.l_29;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/11
 * Author: HuHong
 * Desc: 两数相除
 * review
 ***********************************************************/
class Solution {
    public int divide(int _x, int _y) {
        long x = _x, y = _y;
        boolean flag = x > 0 && y < 0 || x < 0 && y > 0;
        x = Math.abs(x);
        y = Math.abs(y);
        List<Long> exp = new ArrayList<>();
        for(long t = y; t <= x; t += t) {
            exp.add(t);
        }
        long res = 0;
        for(int i = exp.size() - 1; i >= 0; i --) {
            if(x >= exp.get(i)) {
                x -= exp.get(i);
                res += 1L << i;
            }
        }
        if(flag) res = -res;
        return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }
}