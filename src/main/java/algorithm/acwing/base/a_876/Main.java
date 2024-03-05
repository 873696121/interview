package algorithm.acwing.base.a_876;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 快速幂求逆元
 ***********************************************************/

// a mod p 的逆元 = a ^ (p - 2) mod p

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
            int a = sc.nextInt(), p = sc.nextInt();
            System.out.println(a % p == 0 ? "impossible" : quickPow(a, p - 2, p));
        }
    }
}
