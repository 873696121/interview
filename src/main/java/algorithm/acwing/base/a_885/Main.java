package algorithm.acwing.base.a_885;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 求组合数 I
 ***********************************************************/
public class Main {
    final static int N = 2010, P = (int) (1e9 + 7);
    static int n;
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // C i, j = C i - 1, j - 1 + C i - 1, j
        f[0][0] = 1;
        for(int i = 1; i < N; i ++){
            for(int j = 0; j <= i; j ++){
                if(j == 0) f[i][j] = 1;
                else f[i][j] = (f[i - 1][j - 1] + f[i - 1][j]) % P;
            }
        }
        while(n -- > 0) {
            System.out.println(f[sc.nextInt()][sc.nextInt()]);
        }
    }
}
