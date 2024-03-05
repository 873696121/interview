package algorithm.leetcode.l1_100.l51_100.l_54;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 螺旋矩阵
 ***********************************************************/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] st = new boolean[n][m];
        int x = 0, y = 0, i = 0;
        List<Integer> res = new ArrayList<>();
        while(true) {
            res.add(matrix[x][y]);
            st[x][y] = true;
            int nx = x + dx[i], ny = y +dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !st[nx][ny]) {
                x = nx; y = ny;
            }else {
                i = (i + 1) % 4;
                nx = x + dx[i];ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !st[nx][ny]) {
                    x = nx; y = ny;
                }else {
                    break;
                }
            }
        }
        return res;
    }
}