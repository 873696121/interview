package algorithm.leetcode.l201_300.l201_250.l_229;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 229. 多数元素 II
 ***********************************************************/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0, cnta = 0, cntb = 0, n = nums.length;
        for(int x : nums) {
            if(cnta > 0 && x == a) cnta ++;
            else if(cntb > 0 && x == b) cntb ++;
            else if(cnta == 0) {
                a = x;
                cnta++;
            }
            else if(cntb == 0) {
                b = x;
                cntb++;
            }
            else {
                cnta --;
                cntb --;
            }
        }
        List<Integer> res = new ArrayList<>();
        int ca = 0, cb = 0;
        for(int i = 0; i < n; i ++) {
            if(cnta > 0 && nums[i] == a) ca ++;
            if(cntb > 0 && nums[i] == b) cb ++;
        }
        if(ca > n / 3) res.add(a);
        if(cb > n / 3) res.add(b);
        return res;
    }
}