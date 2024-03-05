package algorithm.acwing.base.a_791;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 高精度加法
 ***********************************************************/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(add(sc.next(), sc.next()));
    }

    static String add(String a, String b) {
        StringBuffer sa = new StringBuffer(a);
        StringBuffer sb = new StringBuffer(b);
        sa.reverse();
        sb.reverse();
        StringBuffer res = new StringBuffer();
        for (int i = 0, k = 0; i < sa.length() || i < sb.length() || k > 0; i++) {
            if (i < sa.length()) k += sa.charAt(i) - '0';
            if (i < sb.length()) k += sb.charAt(i) - '0';
            res.append(k % 10);
            k /= 10;
        }
        return res.reverse().toString();
    }
}
