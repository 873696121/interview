package algorithm.leetcode.l101_200.l101_150.l_130;

import java.util.LinkedList;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 被围绕的区域
 ***********************************************************/
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] st = new boolean[n + 1][m + 1];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O') q.add(new int[]{i, j});
            }
        }
        while(q.size() > 0){
            int[] t = q.poll();
            int x = t[0], y = t[1];
            if(st[x][y]) continue;
            st[x][y] = true;
            for(int i = 0; i < 4; i ++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !st[nx][ny] && board[nx][ny] == 'O')
                    q.offer(new int[]{nx, ny});
            }
        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(board[i][j] == 'O' && !st[i][j]) board[i][j] = 'X';
            }
        }
    }
}