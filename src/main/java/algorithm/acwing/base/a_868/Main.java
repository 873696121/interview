package algorithm.acwing.base.a_868;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 筛质数
 ***********************************************************/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] p = new boolean[n + 1];
        int res = 0;
        for(int i = 2; i <= n; i ++){
            if(!p[i]) {
                res ++;
                for(int j = i; j <= n; j += i) p[j] = true;
            }
        }
        System.out.println(res);
    }
}
