package algorithm.acwing.base.a_854;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: Floyd求最短路
 ***********************************************************/
public class Main {
    final static int N = 210, M = 20010, INF = 0x3f3f3f3f;
    static int n, m, K;
    static int[][] g = new int[N][N];

    static void floyd(){
        for(int k = 1; k <= n; k ++){
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= n; j ++){
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        K = sc.nextInt();
        for(int i = 0; i < N; i ++){
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }
        for(int i = 0; i < m; i ++){
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }
        floyd();
        while(K -- > 0) {
            int a , b;
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(g[a][b] > INF / 2 ? "impossible" : g[a][b]);
        }
    }
}
