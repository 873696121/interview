package algorithm.acwing.base.a_786;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc:
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int n;
    static int k;
    static int[] q = new int[N];

    static int quickSort(int[] q, int l, int r, int k) {
        if (l >= r) return q[l];
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
        int len = j - l + 1;
        if(len >= k) return quickSort(q, l, j, k);
        else return quickSort(q, j + 1, r , k - len);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();
        System.out.println(quickSort(q, 0, n - 1, k));
    }
}
