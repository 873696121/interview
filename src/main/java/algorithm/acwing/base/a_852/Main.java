package algorithm.acwing.base.a_852;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: spfa求最短路
 ***********************************************************/
public class Main {
    final static int N = 100010, INF = 0x3f3f3f3f;
    static int n, m, idx;
    static int[] h = new int[N], e = new int[N], w = new int[N], ne = new int[N], d = new int[N], cnt = new int[N];
    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    static String spfa(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i ++){
            q.offer(i);
            st[i] = true;
        }
        while(q.size() > 0) {
            int t = q.poll();
            st[t] = false;
            for(int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(d[j] > d[t] + w[i]) {
                    d[j] = d[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if(cnt[j] >= n) {
                        return "Yes";
                    }
                    if(!st[j]) {
                        st[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        for(int i = 0;  i< m; i ++){
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            add(a, b, c);
        }
        System.out.println(spfa());
    }
}
