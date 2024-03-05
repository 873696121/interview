package algorithm.kickstart.Round_D.D1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    void solve() {
        long[] a = get(), b = get();
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
        int K = sc.nextInt();
        long res = 0;
        for(int i = 0; i <= K; i ++) {
            if(i < a.length && K - i >= 0 && K - i < b.length)
                res = Math.max(res, a[i] + b[K - i]);
        }
        System.out.println(res);
    }

    long[] get() {
        int n = sc.nextInt();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();
        long[] l = new long[n + 1], r = new long[n + 1];
        for(int i = 1; i <= n; i ++) {
            l[i] = q[i - 1] + l[i - 1];
        }
        reverse(q);
        for(int i = 1; i <= n; i ++) {
            r[i] = q[i - 1] + r[i - 1];
        }
        long[] res = new long[n + 1];
        for(int i = 1; i <= n; i ++) {
            long cur = 0;
            for(int j = 0; j <= i; j ++) {
                cur = Math.max(cur, l[j] + r[i - j]);
            }
            res[i] = cur;
        }
        return res;
    }

    void reverse(int[] q) {
        for(int i = 0, j = q.length - 1; i <= j; i ++, j --) {
            swap(q, i, j);
        }
    }

    int tran(boolean c) {
        if (c) return 1;
        return 0;
    }


    void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            solution.solve();
        }
    }
}
