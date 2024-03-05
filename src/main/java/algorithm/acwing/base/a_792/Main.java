package algorithm.acwing.base.a_792;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 高精度减法
 ***********************************************************/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sub(sc.next(), sc.next()));
    }

    static String sub(String a, String b) {
        if (!isBigger(a, b)) return "-" + sub(b, a);
        StringBuffer sa = new StringBuffer(a).reverse();
        StringBuffer sb = new StringBuffer(b).reverse();
        StringBuffer res = new StringBuffer();
        for (int i = 0, k = 0; i < sa.length(); i++) {
            k += sa.charAt(i) - '0';
            if (i < sb.length()) k -= sb.charAt(i) - '0';
            res.append((k % 10 + 10) % 10);
            if (k < 0) k = -1;
            else k = 0;
        }
        while (res.length() > 1 && res.charAt(res.length() - 1) == '0') res.deleteCharAt(res.length() - 1);
        return res.reverse().toString();
    }

    static boolean isBigger(String a, String b) {
        if (a.length() != b.length()) return a.length() > b.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return a.charAt(i) > b.charAt(i);
        }
        return true;
    }
}
