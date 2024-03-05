package algorithm.leetcode.l201_300.l250_300.l_289;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 289. 生命游戏
 ***********************************************************/
class Solution {
    int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++){
                int cnt = 0;
                for(int k = 0; k < dx.length; k ++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1) {
                        cnt ++;
                    }
                }
                System.out.println(cnt);
                res[i][j] = board[i][j];
                if(board[i][j] == 1) {
                    if(cnt < 2 || cnt > 3) res[i][j] = 0;
                } else {
                    if(cnt == 3) res[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < m; j ++)
                board[i][j] = res[i][j];
    }

    void print(int[][] f) {
        for(int i = 0; i < f.length; i ++){
            for(int j = 0; j < f[0].length; j ++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
    }
}