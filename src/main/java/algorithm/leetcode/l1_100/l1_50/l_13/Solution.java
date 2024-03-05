package algorithm.leetcode.l1_100.l1_50.l_13;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 罗马数字转整数
 ***********************************************************/
public class Solution {
    static int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] roms = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public int romanToInt(String s) {
        Map<String, Integer> st = new HashMap<>();
        for (int i = 0; i < roms.length; i++)
            st.put(roms[i], nums[i]);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && st.containsKey(s.substring(i, i + 2))) {
                res += st.get(s.substring(i, i + 2));
                i++;
            } else {
                res += st.get(s.substring(i, i + 1));
            }
        }
        return res;
    }
}
