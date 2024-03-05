package algorithm.acwing.base.a_793;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 高精度乘法
 ***********************************************************/
public class Main {

    static String mul(String a, String b) {
        StringBuffer sa = new StringBuffer(a).reverse();
        StringBuffer sb = new StringBuffer(b).reverse();
        int n = sa.length(), m = sb.length();
        List<Integer> list = new ArrayList<>(Collections.nCopies(n + m, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.set(i + j, (sa.charAt(i) - '0') * (sb.charAt(j) - '0') + list.get(i + j));
            }
        }
        for (int i = 0, k = 0; i < list.size(); i++) {
            k += list.get(i);
            list.set(i, k % 10);
            k /= 10;
        }
        while (list.size() > 1 && list.get(list.size() - 1) == 0) list.remove(list.size() - 1);
        StringBuffer res = new StringBuffer();
        for (Integer c : list) res.append(c);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mul(sc.next(), sc.next()));
    }
}
