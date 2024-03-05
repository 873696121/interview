package algorithm.acwing.base.a_853;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 有边数限制的最短路
 ***********************************************************/
public class Main {
    final static int N = 510, M = 10010, INF = 0x3f3f3f3f;
    static int[] d = new int[N], backup = new int[N];
    static int n, m, k;
    static Node[] g = new Node[M];

    static class Node {
        int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static String bellmanFord() {
        Arrays.fill(d, INF);
        d[1] = 0;
        while (k-- > 0) {
            backup = Arrays.copyOf(d, N);
            for (int i = 0; i < m; i ++){
                int a = g[i].a, b = g[i].b, c = g[i].c;
                d[b] = Math.min(d[b], backup[a] + c);
            }
        }
        return d[n] > INF / 2 ? "impossible" : String.valueOf(d[n]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            g[i] = new Node(a, b, c);
        }
        System.out.println(bellmanFord());
    }
}
