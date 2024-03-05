package algorithm.acwing.base.a_836;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 合并集合
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int[] p = new int[N];
    static int n, m;

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i <= n; i ++) p[i] = i;
        while (m-- > 0) {
            String op = sc.next();
            int a = sc.nextInt(), b = sc.nextInt();
            a = find(a);
            b = find(b);
            if ("M".equals(op)) {
                p[a] = b;
            } else {
                System.out.println(a == b ? "Yes" : "No");
            }
        }
    }

}
