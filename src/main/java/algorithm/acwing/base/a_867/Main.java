package algorithm.acwing.base.a_867;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 分解质因数
 ***********************************************************/
public class Main {

    static Map<Integer, Integer> get(int x) {
        Map<Integer, Integer> res = new TreeMap<>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                int cnt = 0;
                while (x % i == 0) {
                    x /= i;
                    cnt++;
                }
                res.put(i, cnt);
            }
        }
        if (x > 1) res.put(x, 1);
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            Map<Integer, Integer> map = get(sc.nextInt());
            for (Integer key : map.keySet()) {
                System.out.print(key + " " + map.get(key) + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}
