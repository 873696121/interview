package algorithm.acwing.base.a_844;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 走迷宫
 ***********************************************************/
public class Main {
    final static int N = 110;
    static int n, m;
    static int[][] g = new int[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[][] cnt = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = sc.nextInt();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        st[0][0] = true;
        while (q.size() > 0) {
            int[] t = q.poll();
            int x = t[0], y = t[1];
            if (x == n - 1 && y == m - 1) break;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !st[nx][ny] && g[nx][ny] == 0) {
                    st[nx][ny] = true;
                    cnt[nx][ny] = cnt[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(cnt[n - 1][m - 1]);
    }
}
