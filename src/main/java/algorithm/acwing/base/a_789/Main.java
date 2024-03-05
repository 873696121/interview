package algorithm.acwing.base.a_789;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 数的范围
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int[] q = new int[N];
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();
        while (m-- > 0) {
            int x = sc.nextInt();
            int l = 0, r = n - 1;
            while(l < r) {
                int mid = (l + r) >> 1;
                if(q[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if(q[l] != x) System.out.println("-1 -1");
            else {
                System.out.print(l + " ");
                l = 0;
                r = n - 1;
                while(l < r) {
                    int mid = (l + r + 1) >> 1;
                    if(q[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }
}
