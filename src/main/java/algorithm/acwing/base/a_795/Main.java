package algorithm.acwing.base.a_795;

import java.util.Scanner;

public class Main {
    final static int N = 100010;
    static int n, m;
    static int[] s = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i ++) {
            s[i] = sc.nextInt();
            s[i] += s[i - 1];
        }
        while(m -- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
