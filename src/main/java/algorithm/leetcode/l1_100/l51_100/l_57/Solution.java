package algorithm.leetcode.l1_100.l51_100.l_57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 插入区间
 ***********************************************************/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        int i = 0;
        for (; i < n && intervals[i][0] <= newInterval[0]; i++) {
            list.add(Arrays.copyOf(intervals[i], 2));
        }
        list.add(Arrays.copyOf(newInterval, 2));
        for (; i < n; i++)
            list.add(Arrays.copyOf(intervals[i], 2));
        int[][] f = new int[n + 1][2];
        for (i = 0; i < n + 1; i++)
            f[i] = list.get(i);
        return merge(f);
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int L = intervals[0][0], R = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= R) {
                R = Math.max(R, intervals[i][1]);
            } else {
                list.add(new int[]{L, R});
                L = intervals[i][0];
                R = intervals[i][1];
            }
        }
        list.add(new int[]{L, R});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] t = list.get(i);
            res[i][0] = t[0];
            res[i][1] = t[1];
        }
        return res;
    }
}