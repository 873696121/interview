package algorithm.leetcode.l201_300.l201_250.l_210;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 210. 课程表 II
 ***********************************************************/
class Solution {
    static int N = 100010;
    int[] h = new int[N], e = new int[N], ne = new int[N];
    int idx = 0;
    boolean[] st = new boolean[N];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    public int[] findOrder(int n, int[][] g) {
        Arrays.fill(h, -1);
        int[] cnt = new int[n];
        for(int[] t : g) {
            cnt[t[0]] ++;
            add(t[1], t[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            if(cnt[i] == 0) {
                q.offer(i);
                st[i] = true;
            }
        }
        while(q.size() > 0) {
            int t = q.poll();
            res.add(t);
            for(int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                cnt[j] --;
                if(cnt[j] == 0 && !st[j]) {
                    q.offer(j);
                    st[j] = true;
                }
            }
        }
        if(res.size() != n) res.clear();
        int[] r = new int[res.size()];
        for(int i = 0;  i< res.size(); i ++){
            r[i] = res.get(i);
        }
        return r;
    }
}