package algorithm.acwing.base.a_869;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 筛质数
 ***********************************************************/
public class Main {

    static List<Integer> find(int x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                res.add(i);
                if(i * i != x) res.add(x / i);
            }
        }
        res.sort((o1, o2) -> o1 - o2);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            for (Integer t : find(sc.nextInt())) System.out.print(t + " ");
            System.out.println();
        }
    }
}
