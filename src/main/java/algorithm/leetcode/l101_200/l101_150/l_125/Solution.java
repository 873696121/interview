package algorithm.leetcode.l101_200.l101_150.l_125;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 验证回文串
 ***********************************************************/
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) i ++;
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j --;
            if(i < j) {
                if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}