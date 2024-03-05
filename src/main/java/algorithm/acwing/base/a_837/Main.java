package algorithm.acwing.base.a_837;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 连通块中点的数量
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int[] p = new int[N];
    static int[] cnt = new int[N];
    static int n, m;

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i <= n; i ++) {
            p[i] = i;
            cnt[i] = 1;
        }
        while (m-- > 0) {
            String op = sc.next();
            if("C".equals(op)) {
                int a = sc.nextInt(), b = sc.nextInt();
                a = find(a);
                b = find(b);
                if(a == b) continue;
                p[a] = b;
                cnt[b] += cnt[a];
            }else if("Q1".equals(op)) {
                int a = sc.nextInt(), b = sc.nextInt();
                a = find(a);
                b = find(b);
                System.out.println(a == b ? "Yes" : "No");
            }else {
                int a = sc.nextInt();
                a = find(a);
                System.out.println(cnt[a]);
            }
        }
    }

}
