package algorithm.acwing.base.a_154;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 滑动窗口
 ***********************************************************/
public class Main {
    final static int N = 1000010;
    static int n;
    static int[] q = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        Deque<Integer> dqMax = new ArrayDeque<>();
        Deque<Integer> dqMin = new ArrayDeque<>();
        List<Integer> resMax = new ArrayList<>();
        List<Integer> resMin = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            q[i] = sc.nextInt();
            while(dqMax.size() > 0 && i - dqMax.peekFirst() + 1 > m) dqMax.removeFirst();
            while(dqMin.size() > 0 && i - dqMin.peekFirst() + 1 > m) dqMin.removeFirst();
            while(dqMax.size() > 0 && q[i] >= q[dqMax.peekLast()]) dqMax.removeLast();
            while(dqMin.size() > 0 && q[i] <= q[dqMin.peekLast()]) dqMin.removeLast();
            dqMax.addLast(i);
            dqMin.addLast(i);
            if(i >= m - 1) {
                resMax.add(dqMax.peekFirst());
                resMin.add(dqMin.peekFirst());
            }
        }
        for(Integer x : resMin) System.out.print(q[x] + " ");
        System.out.println();
        for(Integer x : resMax) System.out.print(q[x] + " ");
    }
}
