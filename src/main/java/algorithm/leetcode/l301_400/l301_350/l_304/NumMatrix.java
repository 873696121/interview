package algorithm.leetcode.l301_400.l301_350.l_304;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 304. 二维区域和检索 - 矩阵不可变
 ***********************************************************/
class NumMatrix {

    int[][] f = new int[210][210];
    public NumMatrix(int[][] matrix) {
        for(int i = 1; i <= matrix.length; i ++) {
            for(int j = 1; j <= matrix[0].length; j ++) {
                f[i][j] = matrix[i - 1][j - 1] + f[i - 1][j] + f[i][j - 1] - f[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return f[row2 + 1][col2 + 1] - f[row1][col2 + 1] - f[row2 + 1][col1] + f[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */