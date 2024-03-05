 package algorithm.acwing.base.a_800;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 数组元素的目标和
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int n, m, k;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int j = 0; j < m; j++) b[j] = sc.nextInt();
        int i = 0, j = m - 1;
        int[] res = new int[2];
        while (i < n && j >= 0) {
            if (a[i] + b[j] == k) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (a[i] + b[j] > k) j--;
            else i++;
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
