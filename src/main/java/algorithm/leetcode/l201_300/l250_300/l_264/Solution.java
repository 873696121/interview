package algorithm.leetcode.l201_300.l250_300.l_264;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 264. 丑数 II
 * review
 ***********************************************************/
class Solution {
    List<Integer> res = new ArrayList<>();
    public int nthUglyNumber(int n) {
        res.add(1);
        for(int i = 0, j = 0, k = 0; res.size() < n; ) {
            int t = Math.min(res.get(i) * 2, Math.min(res.get(j) * 3, res.get(k) * 5));
            res.add(t);
            if(t == res.get(i) * 2) i ++;
            if(t == res.get(j) * 3) j ++;
            if(t == res.get(k) * 5) k ++;
        }
        return res.get(res.size() - 1);
    }
}