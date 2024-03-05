package algorithm.acwing.base.a_849;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/3
 * Author: HuHong
 * Desc: Dijkstra求最短路 I
 ***********************************************************/
public class Main {
    final static int N = 510, INF = 0x3f3f3f3f;
    static int[] d = new int[N];
    static int[][] g = new int[N][N];
    static int n, m;
    static boolean[] st = new boolean[N];

    static int dijkstra() {
        Arrays.fill(d, INF);
        d[1] = 0;
        for(int i = 0; i < n; i ++){
            int u = -1, MIN = INF;
            for(int j = 1; j <= n; j ++){
                if(!st[j] && d[j] < MIN) {
                    MIN = d[j];
                    u = j;
                }
            }
            if(u == -1) return -1;
            st[u] = true;
            for(int j = 1; j <= n; j ++){
                d[j] = Math.min(d[j], d[u] + g[u][j]);
            }
        }
        return d[n] == INF ? -1 : d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < N; i ++)
            Arrays.fill(g[i], INF);
        for(int i = 1; i <= n; i ++) g[i][i] = 0;
        for(int i = 0; i < m; i ++){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }
        System.out.println(dijkstra());
    }
}
