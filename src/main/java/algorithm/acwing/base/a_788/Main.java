package algorithm.acwing.base.a_788;

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
    static int[] temp = new int[N];

    static long mergeSort(int[] q, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) >> 1;
        long res = mergeSort(q, l, mid) + mergeSort(q, mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r) {
            if(q[i] <= q[j]) temp[k ++] = q[i ++];
            else {
                res += mid - i + 1;
                temp[k ++] = q[j ++];
            }
        }
        while(i <= mid) temp[k ++] = q[i ++];
        while(j <= r) temp[k ++] = q[j ++];
        for(i = l, j = 0; i <= r; i ++, j ++) q[i] = temp[j];
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();
        System.out.println(mergeSort(q, 0, n - 1));
    }
}
