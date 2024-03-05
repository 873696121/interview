package algorithm.acwing.base.a_866;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 试除法判定质数
 ***********************************************************/
public class Main {

    static boolean isPrime(long x) {
        if(x <= 1) return false;
        for(long i = 2; i * i <= x; i ++){
            if(x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while(m -- > 0) {
            int x = sc.nextInt();
            System.out.println(isPrime(x) ? "Yes" : "No");
        }
    }
}
