package algorithm.leetcode.l1_100.l51_100.l_97;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 交错字符串
 ***********************************************************/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(n + m != s3.length()) return false;
        boolean[][] f = new boolean[n + 1][m + 1];
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;
        for(int i = 0; i <= n; i ++){
            for(int j = 0; j <= m; j ++){
                if(i == 0 && j == 0) f[i][j] = true;
                else {
                    if(i > 0 && s1.charAt(i) == s3.charAt(i + j) && f[i - 1][j]) f[i][j] = true;
                    if(j > 0 && s2.charAt(j) == s3.charAt(i + j) && f[i][j - 1]) f[i][j] = true;
                }
            }
        }
        return f[n][m];
    }
}