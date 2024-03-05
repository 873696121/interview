package algorithm.leetcode.l1_100.l1_50.l_36;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 有效的数独
 ***********************************************************/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] a = new boolean[10][9], b = new boolean[10][9];
        boolean[][][] c = new boolean[10][3][3];
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                if(board[i][j] == '.') continue;
                int t = board[i][j] - '0';
//                System.out.println(t + " " + board[i][j]);
                if(a[t][i] || b[t][j] || c[t][i / 3][j / 3]) return false;
                a[t][i] = b[t][j] = c[t][i / 3][j / 3] = true;
            }
        }
        return true;
    }
}