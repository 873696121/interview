package algorithm.leetcode.l1_100.l51_100.l_65;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 有效数字
 * review
 ***********************************************************/
class Solution {
    int pos = 0;
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberic = scanInteger(s);
        if(pos < s.length() && s.charAt(pos) == '.') {
            ++ pos;
            numberic |= scanUnsignedInteger(s);
        }
        if(pos < s.length() && (s.charAt(pos) == 'e' || s.charAt(pos) == 'E')) {
            ++ pos;
            numberic &= scanInteger(s);
        }
        return numberic && pos == s.length();
    }

    boolean scanInteger(String s) {
        if(pos < s.length() && (s.charAt(pos) == '+' || s.charAt(pos) == '-')) pos ++;
        return scanUnsignedInteger(s);
    }

    boolean scanUnsignedInteger(String s) {
        int p = pos;
        while(pos < s.length() && Character.isDigit(s.charAt(pos))) pos ++;
        return pos > p;
    }
}