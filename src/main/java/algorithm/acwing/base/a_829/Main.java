package algorithm.acwing.base.a_829;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 模拟队列
 ***********************************************************/
public class Main {
    final static int N = 500010;
    static int[] q = new int[N];
    static int hh = 0, tt = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n -- > 0) {
            String op = sc.next();
            if("push".equals(op)) {
                int x = sc.nextInt();
                q[++ tt] = x;
            }else if("pop".equals(op)) {
                ++ hh;
            }else if("empty".equals(op)) {
                System.out.println(hh > tt ? "YES" : "NO");
            }else {
                System.out.println(q[hh]);
            }
        }
    }
}
