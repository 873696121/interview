package algorithm.leetcode.l1_100.l1_50.l_44;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 通配符匹配
 * review
 ***********************************************************/

/**
 * 非* f[i][j] = f[i - 1][j - 1]
 * *   f[i][j] = f[i][j - 1] | f[i - 1][j - 1] | ... | f[0][j - 1]
 *     f[i - 1][j] = f[i - 1][j - 1] | f[i - 3][j - 1] | ... | f[0][j - 1]
 *     f[i][j] = f[i][j - 1] | f[i - 1][j]
 */

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for(int i = 0; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                char t = p.charAt(j - 1);
                if(t == '*') {
                    f[i][j] = f[i][j - 1] || i > 0 && f[i - 1][j];
                } else {
                    f[i][j] = (t == '?' || i > 0 && s.charAt(i - 1) == t) && i > 0 && f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}