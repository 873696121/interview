package algorithm.acwing.base.a_801;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 二进制中1的个数
 ***********************************************************/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n -- > 0) {
            int x = sc.nextInt();
            int res = 0;
            while(x != 0) {
                res += x & 1;
                x >>= 1;
            }
            System.out.print(res + " ");
        }
    }
}
