package algorithm.acwing.base.a_143;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 最大异或对
 ***********************************************************/
public class Main {
    final static int N = 3000000;
    static int[][] f = new int[N][2];
    static int idx = 0;

    static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int t = x >> i & 1;
            if (f[p][t] == 0) f[p][t] = ++idx;
            p = f[p][t];
        }
    }

    static int get(int x) {
        int p = 0;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int t = x >> i & 1;
            if (f[p][1 - t] > 0) {
                p = f[p][1 - t];
                res += 1 << i;
            } else {
                p = f[p][t];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            insert(x);
            res = Math.max(res, get(x));
        }
        System.out.println(res);
    }
}
