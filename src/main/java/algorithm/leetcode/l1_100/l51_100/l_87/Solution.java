package algorithm.leetcode.l1_100.l51_100.l_87;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 扰乱字符串
 * review
 ***********************************************************/
class Solution {
    final static int N = 35;
    boolean[][][] f = new boolean[N][N][N];
    public boolean isScramble(String a, String b) {
        int n = a.length();
        for(int k = 1; k <= n; k ++){
            for(int i = 0; i + k - 1 < n; i ++){
                for(int j = 0; j + k - 1 < n; j ++){
                    if(k == 1) {
                        if(a.charAt(i) == b.charAt(j)) f[i][j][k] = true;
                    }else {
                        for(int u = 1; u < k; u ++){
                            if((f[i][j][u] && f[i + u][j + u][k - u]) || (f[i][j + k - u][u] && f[i + u][j][k - u])){
                                f[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }
}