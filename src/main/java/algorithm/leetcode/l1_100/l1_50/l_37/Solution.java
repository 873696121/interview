package algorithm.leetcode.l1_100.l1_50.l_37;

/***********************************************************                                          *
 * Time: 2022/5/17
 * Author: HuHong
 * Desc: 解数独
 * review
 ***********************************************************/
class Solution {
    final static int N = 10;
    int n;
    boolean[][] a = new boolean[N][N], b = new boolean[N][N];
    boolean[][][] c = new boolean[N][N][N];

    public void solveSudoku(char[][] board) {
        n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    a[t][i] = b[t][j] = c[t][i / 3][j / 3] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    boolean dfs(char[][] s, int x, int y) {
        if (y == 9) {
            y = 0;
            x++;
        }
        if (x == 9) return true;
        if(s[x][y] != '.') return dfs(s, x, y + 1);
        for (int i = 0; i < 9; i++) {
            if (!a[i][x] && !b[i][y] && !c[i][x / 3][y / 3]) {
                a[i][x] = b[i][y] = c[i][x / 3][y / 3] = true;
                s[x][y] = (char) ('1' + i);
                if (dfs(s, x, y + 1)) return true;
                s[x][y] = '.';
                a[i][x] = b[i][y] = c[i][x / 3][y / 3] = false;
            }
        }
        return false;
    }
}