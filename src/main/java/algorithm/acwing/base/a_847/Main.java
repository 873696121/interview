package algorithm.acwing.base.a_847;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/3
 * Author: HuHong
 * Desc: 图中点的层次
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int[] h = new int[N], ne = new int[N], e = new int[N];
    static int idx = 0, n, m;
    static Map<Integer, Integer> d = new HashMap<>();

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            add(a, b);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        d.put(1, 0);
        while (q.size() > 0) {
            int t = q.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(!d.containsKey(j)) {
                    d.put(j, d.get(t) + 1);
                    q.offer(j);
                }
            }
        }
        System.out.println(d.getOrDefault(n, -1));
    }
}
