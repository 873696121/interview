 package algorithm.acwing.base.a_858;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: Prim算法求最小生成树
 ***********************************************************/
public class Main {
    final static int N = 510, INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];
    static int n, m;

    static String prim(){
        Arrays.fill(d, INF);
        d[1] = 0;
        int res = 0;
        for(int i = 0; i < n; i ++){
            int u = -1, MIN = INF;
            for(int j = 1; j <= n; j ++){
                if(!st[j] && d[j] < MIN) {
                    MIN = d[j];
                    u = j;
                }
            }
            if(u == -1) return "impossible";
            st[u] = true;
            res += d[u];
            for(int j = 1; j <= n; j ++){
                if(!st[j]) d[j] = Math.min(d[j], g[u][j]);
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt();
        m =  sc.nextInt();
        for(int i = 0; i < N; i ++)
            Arrays.fill(g[i], INF);
        for(int i = 0; i < m; i ++){
            int a ,b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        System.out.println(prim());
    }
}
