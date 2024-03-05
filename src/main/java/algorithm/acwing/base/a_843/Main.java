package algorithm.acwing.base.a_843;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: n-皇后问题
 ***********************************************************/
public class Main {
    final static int N = 50;
    static int n;
    static char[][] cur = new char[N][N];
    static boolean[] a = new boolean[N], b = new boolean[N], c = new boolean[N];

    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(cur[i][j]);
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cur[u][i] == '.' && !a[i] && !b[i + u] && !c[i - u + n]) {
                a[i] = b[i + u] = c[i - u + n] = true;
                cur[u][i] = 'Q';
                dfs(u + 1);
                cur[u][i] = '.';
                a[i] = b[i + u] = c[i - u + n] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cur[i][j] = '.';
        dfs(0);
    }
}
