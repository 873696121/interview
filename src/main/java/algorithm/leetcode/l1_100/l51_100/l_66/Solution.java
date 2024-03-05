package algorithm.leetcode.l1_100.l51_100.l_66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 加一
 ***********************************************************/
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        for(int i = digits.length - 1, k = 1; i >= 0 || k > 0; i --) {
            if(i >= 0) k += digits[i];
            list.add(k % 10);
            k /= 10;
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i ++){
            res[i] = list.get(i);
        }
        return res;
    }
}