package algorithm.acwing.base.a_838;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 堆排序
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int n, m, size;
    static int[] q = new int[N];

    static void down(int x) {
        int u = x;
        if (x * 2 <= size && q[x * 2] <= q[u]) u = x * 2;
        if(x * 2 + 1 <= size && q[x * 2 + 1] <= q[u]) u = x * 2 + 1;
        if(u != x) {
            int temp = q[u];
            q[u] = q[x];
            q[x] = temp;
            down(u);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        size = n;
        for (int i = 1; i <= n; i++) q[i] = sc.nextInt();
        for (int i = n / 2; i > 0; i--) down(i);
        while (m-- > 0) {
            System.out.print(q[1] + " ");
            q[1] = q[size --];
            down(1);
        }
    }
}
