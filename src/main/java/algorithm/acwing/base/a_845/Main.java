package algorithm.acwing.base.a_845;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 八数码
 ***********************************************************/
public class Main {

    static String swap(String s, int l, int r) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(l, s.charAt(r));
        sb.setCharAt(r, s.charAt(l));
        return sb.toString();
    }

    static int bfs(String start, String end) {
        Map<String, Integer> cnt = new HashMap<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        cnt.put(start, 0);
        while (q.size() > 0) {
            String t = q.poll();
            if (end.equals(t)) return cnt.get(end);
            int index = t.indexOf('x');
            int x = index / 3, y = index % 3, cur = cnt.get(t);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    String p = swap(t, index, nx * 3 + ny);
                    if (!cnt.containsKey(p)) {
                        cnt.put(p, cur + 1);
                        q.offer(p);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String start = "";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++)
            start += sc.next();
        System.out.println(bfs(start, "12345678x"));
    }
}
