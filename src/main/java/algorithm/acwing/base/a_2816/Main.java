package algorithm.acwing.base.a_2816;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 判断子序列
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int n, m;
    static int[] a = new int[N], b = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i ++) a[i] = sc.nextInt();
        for(int i = 0; i < m; i ++) b[i] = sc.nextInt();
        int j = 0;
        for(int i = 0; i < m; i ++){
            if(b[i] == a[j]) j ++;
            if(j == n) break;
        }
        if(j == n) System.out.println("Yes");
        else System.out.println("No");
    }
}
