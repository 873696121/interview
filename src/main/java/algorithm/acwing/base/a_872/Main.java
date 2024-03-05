package algorithm.acwing.base.a_872;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 最大公约数
 ***********************************************************/
public class Main {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            System.out.println(gcd(sc.nextInt(), sc.nextInt()));
        }
    }
}
