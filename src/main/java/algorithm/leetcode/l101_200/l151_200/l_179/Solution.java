package algorithm.leetcode.l101_200.l151_200.l_179;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/6/14
 * Author: HuHong
 * Desc: 最大数
 ***********************************************************/
class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (o1, o2) -> (int) -(Long.parseLong(o1 + o2) - Long.parseLong(o2 + o1)));
        // System.out.println(Arrays.toString(s));
        StringBuilder sb = new StringBuilder();
        for (String t : s) {
            sb.append(t);
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}