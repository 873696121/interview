package algorithm.leetcode.l1_100.l51_100.l_73;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 矩阵置零
 ***********************************************************/
class Solution {
    public void setZeroes(int[][] matrix) {
//        print(matrix);
        int n = matrix.length, m = matrix[0].length;
        // 记录第一行第一列是否需要清零
        boolean flagX = false, flagY = false;
        for (int i = 0; i < n; i++)
            if (matrix[i][0] == 0) flagX = true;
        for (int i = 0; i < m; i++)
            if (matrix[0][i] == 0) flagY = true;
        // 将第一行第一列作为记录数组，记录对应行列是否需要清零
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
//        print(matrix);
        // 将除第一行第一列外的数组清零
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++)
                    matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++)
                    matrix[i][j] = 0;
            }
        }
        // 清零第一行第一列
        if (flagX)
            for (int i = 0; i < n; i++) matrix[i][0] = 0;
        if (flagY)
            for (int i = 0; i < m; i++) matrix[0][i] = 0;
//        print(matrix);
    }

    void print(int[][] g) {
        for (int i = 0; i < g.length; i++)
            System.out.println(Arrays.toString(g[i]));
        System.out.println();
        System.out.println();
    }
}