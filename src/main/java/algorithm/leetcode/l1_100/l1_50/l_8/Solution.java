package algorithm.leetcode.l1_100.l1_50.l_8;

class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') i++;
        if (i == n) return 0;
        boolean flag = false;
        if (s.charAt(i) == '+') i++;
        else if (s.charAt(i) == '-') {
            i++;
            flag = true;
        }
        if (i == n) return 0;
        if (!Character.isDigit(s.charAt(i))) {
            return 0;
        }
        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + s.charAt(i) - '0';
            i++;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                break;
            }
        }
        if (flag) res = -res;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }
}