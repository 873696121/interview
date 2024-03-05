package algorithm.leetcode.l1_100.l51_100.l_74;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 搜索二维矩阵
 ***********************************************************/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while(i < n && j >= 0) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j --;
            else i ++;
        }
        return false;
    }
}