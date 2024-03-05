package algorithm.acwing.base.a_859;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: Kruskal算法求最小生成树
 ***********************************************************/
public class Main {
    final static int N = 100010, M = 200010, INF = 0x3f3f3f3f;
    static int n, m;
    static int[] p = new int[N];
    static List<Node> v = new ArrayList<>();

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    static class Node {
        int a, b, w;

        public Node(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    static String kruskal() {
        v.sort((o1, o2) -> o1.w - o2.w);
        int res = 0, cnt = 0;
        for (Node node : v) {
            int a = node.a, b = node.b, w = node.w;
            a = find(a);
            b = find(b);
            if (a != b) {
                p[a] = b;
                res += w;
                cnt++;
            }
        }
        return cnt == n - 1 ? String.valueOf(res) : "impossible";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            v.add(new Node(a, b, w));
        }
        for (int i = 1; i <= n; i++) p[i] = i;
        System.out.println(kruskal());
    }
}
