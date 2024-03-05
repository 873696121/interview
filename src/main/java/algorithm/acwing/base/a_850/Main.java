package algorithm.acwing.base.a_850;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/3
 * Author: HuHong
 * Desc: Dijkstra求最短路 II
 ***********************************************************/
public class Main {
    final static int N = 1000010, INF = 0x3f3f3f3f;
    static int n , m, idx;
    static int[] h = new int[N], e = new int[N], w = new int[N], ne = new int[N], d = new int[N];
    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    static int dijkstra() {
        Arrays.fill(d, INF);
        d[1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        q.offer(new int[]{0, 1});
        while(q.size() > 0) {
            int[] t = q.poll();
            int ver = t[1];
            if(ver == n) break;
            if(st[ver]) continue;
            st[ver] = true;
            for(int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];
                if(d[j] > d[ver] + w[i]) {
                    d[j] = d[ver] + w[i];
                    q.offer(new int[]{d[j], j});
                }
            }
        }
        return d[n] == INF ? -1 : d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        for(int i = 0; i < m; i ++){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
        }
        System.out.println(dijkstra());
    }
}
