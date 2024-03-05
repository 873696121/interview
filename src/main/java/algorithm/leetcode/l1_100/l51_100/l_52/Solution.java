package algorithm.leetcode.l1_100.l51_100.l_52;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: N 皇后
 ***********************************************************/
class Solution {
    final static int N = 22;
    boolean[] a = new boolean[N], b = new boolean[N], c = new boolean[N];
    char[][] g;
    int n;
    int res = 0;
    public int totalNQueens(int _n) {
        n = _n;
        g = new char[n][n];
        for(int i = 0; i < n; i ++)
            Arrays.fill(g[i], '.');
        dfs(0);
        return res;
    }

    void dfs(int u) {
        if(u == n) {
            res ++;
            return;
        }
        for(int i = 0; i < n; i ++){
            if(!a[i] && !b[i + u] && !c[i - u + n]) {
                a[i] = b[i + u] = c[i - u + n] = true;
                g[u][i] = 'Q';
                dfs(u + 1);
                g[u][i] = '.';
                a[i] = b[i + u] = c[i - u + n] = false;
            }
        }
    }
}