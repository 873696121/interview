package algorithm.acwing.base.a_886;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 求组合数 II
 ***********************************************************/

// 使用快速幂

public class Main {
    static int quickPow(long a, long b, long p) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % p;
            a = (a * a) % p;
            b >>= 1;
        }
        return (int) res;
    }

    final static int N = 100100, mod = (int) (1e9 + 7);
    static long[] fac = new long[N], infac = new long[N];

    public static void main(String[] args) {
        fac[0] = infac[0] = 1;
        for (int i = 1; i < N; i++) {
            fac[i] = (fac[i - 1] * i) % mod;
            infac[i] = (infac[i - 1] * quickPow(i, mod - 2, mod)) % mod;
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            long res = (fac[a] * infac[b] % mod) * infac[a - b] % mod;
            System.out.println(res);
        }
    }
}
