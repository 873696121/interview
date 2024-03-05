package algorithm.acwing.base.a_803;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 测试排序
 ***********************************************************/
public class Compare {
    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Pair o) {
            return o.a - a;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(1, 2));
        list.add(new Pair(2, 3));
        list.add(new Pair(3, 4));
        Collections.sort(list, (a, b) -> a.a - b.a);
        System.out.println(list);

        int[][] q = new int[4][4];
        int cur = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                q[i][j] = cur++;
            }
        }
        Arrays.sort(q, (a, b) -> {
            for(int i = 0; i < 4; i ++){
                if(a[i] != b[i]) return b[i] - a[i];
            }
            return 1;
        });
        for (int[] p : q) {
            System.out.println(Arrays.toString(p));
        }
    }
}
