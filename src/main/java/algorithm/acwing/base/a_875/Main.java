package algorithm.acwing.base.a_875;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 快速幂
 ***********************************************************/
public class Main {
    static long quickPow(long a, long b, long p) {
        long res = 1;
        while(b > 0) {
            if((b & 1) != 0) res = (res * a) % p;
            a *= a;
            a %= p;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n -- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), p = sc.nextInt();
            System.out.println(quickPow(a, b, p));
        }
    }
}
