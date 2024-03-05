package algorithm.leetcode.l1_100.l1_50.l_38;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 外观数列
 ***********************************************************/
class Solution {
    public String countAndSay(int n) {
        String t = "1";
        while (n-- > 1) {
            StringBuffer sb = new StringBuffer();
            for(int i = 0, cnt = 0; i < t.length(); i ++){
                cnt++;
                if(i == t.length() - 1 || t.charAt(i) != t.charAt(i + 1)) {
                    sb.append(cnt).append(t.charAt(i));
                    cnt = 0;
                }
            }
            t = sb.toString();
        }
        return t;
    }
}