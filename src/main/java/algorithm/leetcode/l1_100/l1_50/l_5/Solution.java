package algorithm.leetcode.l1_100.l1_50.l_5;

class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String t = get(s, i, i);
            if (res.length() < t.length()) res = t;
            if (i > 0) {
                t = get(s, i - 1, i);
                if (res.length() < t.length()) res = t;
            }
        }
        return res;
    }

    public static String get(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l --;
            r ++;
        }
        return s.substring(l + 1, r);
    }
}