package algorithm.leetcode.l101_200.l151_200.l_200;

import java.util.LinkedList;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 200. 岛屿数量
 ***********************************************************/
class Solution {

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(grid[i][j] == '0') continue;
                res ++;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                while(q.size() > 0) {
                    int[] t = q.poll();
                    int x = t[0], y = t[1];
                    grid[x][y] = '0';
                    for(int ii = 0; ii < 4; ii ++){
                        int nx = x + dx[ii], ny = y + dy[ii];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
                            q.offer(new int[]{nx, ny});
                            grid[nx][ny] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}