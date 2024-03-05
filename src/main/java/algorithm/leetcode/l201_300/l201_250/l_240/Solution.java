package algorithm.leetcode.l201_300.l201_250.l_240;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 240. 搜索二维矩阵 II
 ***********************************************************/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        int i = 0, j = m - 1;
        while(i < n && j >= 0) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j --;
            else i ++;
        }
        return false;
    }
}