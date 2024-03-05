package algorithm.leetcode.l301_400.l301_350.l_334;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 334. 递增的三元子序列
 ***********************************************************/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int t : nums) {
            if(list.size() == 3) return true;
            if(list.size() == 0 || (t > list.get(list.size() - 1) && list.size() < 3)) {
                list.add(t);
            }else {
                int l = 0, r = list.size() - 1;
                while(l < r) {
                    int mid = l + r >> 1;
                    if(list.get(mid) >= t) r = mid;
                    else l = mid + 1;
                }
                list.set(l, t);
            }
        }
        return list.size() >= 3;
    }
}
