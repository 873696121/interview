package algorithm.leetcode.l201_300.l201_250.l_202;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 202. 快乐数
 ***********************************************************/
class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> h = new HashMap<>();
        while(n != 1 && !h.containsKey(n)) {
            // System.out.println(n);
            h.put(n, true);
            n = get(n);
        }
        return n == 1;
    }

    int get(int n) {
        int res = 0;
        while(n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}