package algorithm.leetcode.l1_100.l51_100.l_79;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 单词搜索
 ***********************************************************/
class Solution {
    final static int N = 20;
    boolean[][] st = new boolean[N][N];
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int n, m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (dfs(board, word, 0, i, j)) return true;
        return false;
    }

    boolean dfs(char[][] board, String word, int u, int x, int y) {
        if (board[x][y] != word.charAt(u)) return false;
        if (u == word.length() - 1) return true;
        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !st[nx][ny]) {
                if(dfs(board, word, u + 1, nx, ny)) return true;
            }
        }
        st[x][y] = false;
        return false;
    }
}