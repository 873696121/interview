package algorithm.acwing.base.a_841;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 字符串哈希
 ***********************************************************/
public class Main {
    final static int N = 100010, P = 131;
    static int n, m;
    static char[] s;
    static long[] f = new long[N], p = new long[N];

    static long get(int l, int r) {
        return f[r] - f[l - 1] * p[r - l + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = (" " + sc.next()).toCharArray();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] * P + s[i] - '0';
            p[i] = p[i - 1] * P;
        }
        while (m-- > 0) {
            int l1 = sc.nextInt(), r1 = sc.nextInt(), l2 = sc.nextInt(), r2 = sc.nextInt();
            System.out.println(get(l1, r1) == get(l2, r2) ? "Yes" : "No");
        }
    }
}
