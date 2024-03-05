package algorithm.leetcode.l201_300.l201_250.l_217;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 217. 存在重复元素
 ***********************************************************/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> st = new HashMap<>();
        for (int t : nums) {
            if (st.containsKey(t)) return true;
            st.put(t, true);
        }
        return false;
    }
}