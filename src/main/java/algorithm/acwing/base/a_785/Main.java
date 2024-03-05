package algorithm.acwing.base.a_785;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc:
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int n;
    static int[] q = new int[N];

    static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1, x = q[(l + r) >> 1];
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();
        quickSort(q, 0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(q[i] + " ");
    }
}
