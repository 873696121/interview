package algorithm.acwing.base.a_799;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 最长连续不重复子序列
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int[] q = new int[N];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < n; i ++){
            q[i] = sc.nextInt();
            cnt.put(q[i], cnt.getOrDefault(q[i], 0) + 1);
            while(cnt.getOrDefault(q[i], 0) > 1) {
                cnt.put(q[j], cnt.get(q[j]) - 1);
                j ++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
