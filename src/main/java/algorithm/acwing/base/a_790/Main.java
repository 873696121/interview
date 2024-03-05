package algorithm.acwing.base.a_790;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 数的三次方根
 ***********************************************************/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double l = -10000, r = 10000;
        while(r - l > 1e-8) {
            double mid = (l + r) / 2;
            if(mid * mid * mid > x) r = mid;
            else l = mid;
        }
        System.out.printf("%.6f", l);
    }
}
