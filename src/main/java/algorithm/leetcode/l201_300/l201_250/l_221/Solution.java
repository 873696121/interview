package algorithm.leetcode.l201_300.l201_250.l_221;

import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 221. 最大正方形
 ***********************************************************/
// todo dp写法
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        int[][] f = new int[n][m];
        for(int j = 0; j < m; j ++){
            for(int i = 0; i < n; i ++){
                if(matrix[i][j] == '1') {
                    f[i][j] = 1;
                    if(i > 0) f[i][j] += f[i - 1][j];
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i ++){
            res = Math.max(res, find(f[i]));
        }
        return res;
    }

    int find(int[] f) {
        int n = f.length;
        Stack<Integer> st = new Stack<>();
        int[] l = new int[n], r = new int[n];
        for(int i = 0; i < n; i ++){
            while(st.size() > 0 && f[st.peek()] >= f[i]) st.pop();
            int t = -1;
            if(st.size() > 0) t = st.peek();
            l[i] = t;
            st.push(i);
        }
        st.clear();
        for(int i = n - 1; i >= 0; i --){
            while(st.size() > 0 && f[st.peek()] >= f[i]) st.pop();
            int t = n;
            if(st.size() > 0) t = st.peek();
            r[i] = t;
            st.push(i);
        }
        int res = 0;
        for(int i = 0; i < n; i ++){
            int u = Math.min(r[i] - l[i] - 1, f[i]);
            res = Math.max(res, u);
        }
        return res * res;
    }
}