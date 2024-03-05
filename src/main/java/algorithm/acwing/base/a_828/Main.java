package algorithm.acwing.base.a_828;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 模拟栈
 ***********************************************************/
public class Main {

    final static int N = 500010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q = new int[N];
        int t = -1;
        while (n-- > 0) {
            String op = sc.next();
            if ("push".equals(op)) {
                int x = sc.nextInt();
                q[++t] = x;
            }else if("pop".equals(op)) {
                if(t >= 0) t --;
            }else if("empty".equals(op)) {
                if(t == -1) System.out.println("YES");
                else System.out.println("NO");
            }else {
                System.out.println(q[t]);
            }
        }
    }
}
