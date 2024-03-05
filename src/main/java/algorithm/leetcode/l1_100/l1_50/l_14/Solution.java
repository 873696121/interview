package algorithm.leetcode.l1_100.l1_50.l_14;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 最长公共前缀
 ***********************************************************/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0) return "";
        int i = 0;
        while(true) {
            boolean flag = true;
            for(String s : strs) {
                if(i >= s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) i ++;
            else break;
        }
        return strs[0].substring(0, i);
    }
}
