package algorithm.acwing.base.a_848;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/3
 * Author: HuHong
 * Desc: 有向图的拓扑序列
 ***********************************************************/
public class Main {
    final static int N = 100010;
    static int n, m, idx;
    static int[] h = new int[N], e = new int[N], ne = new int[N], cnt = new int[N];
    static boolean[] st = new boolean[N];

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    static void topSort() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i ++){
            if(cnt[i] == 0) {
                q.offer(i);
                st[i] = true;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(q.size() > 0) {
            int t = q.poll();
            res.add(t);
            for(int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(!st[j]) {
                    cnt[j] --;
                    if(cnt[j] == 0) {
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        if(res.size() != n) {
            System.out.println(-1);
        }else {
            for(int x : res) System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        for(int i = 0; i < m;  i++){
            int a = sc.nextInt(), b = sc.nextInt();
            add(a, b);
            cnt[b] ++;
        }
        topSort();
    }
}
