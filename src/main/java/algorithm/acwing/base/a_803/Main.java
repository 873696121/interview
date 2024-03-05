package algorithm.acwing.base.a_803;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/1
 * Author: HuHong
 * Desc: 区间合并
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int n;
    static List<Integer[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Integer[] q = new Integer[2];
            q[0] = sc.nextInt();
            q[1] = sc.nextInt();
            list.add(q);
        }
        list.sort((o1, o2) -> o1[0] - o2[0]);
        int L = list.get(0)[0], R = list.get(0)[1];
        int res = 0;
        for(int i = 1; i < list.size(); i ++){
            if(list.get(i)[0] <= R) {
                R = Math.max(R, list.get(i)[1]);
            }else {
                res ++;
                L = list.get(i)[0];
                R = list.get(i)[1];
            }
        }
        res ++;
        System.out.println(res);
    }
}
