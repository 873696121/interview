package algorithm.leetcode.l1_100.l51_100.l_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 合并区间
 ***********************************************************/
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int L = intervals[0][0], R = intervals[0][1];
        for(int i = 1; i < intervals.length; i ++){
            if(intervals[i][0] <= R) {
                R = Math.max(R, intervals[i][1]);
            }else {
                list.add(new int[]{L, R});
                L = intervals[i][0];
                R = intervals[i][1];
            }
        }
        list.add(new int[]{L, R});
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i ++){
            int[] t = list.get(i);
            res[i][0] = t[0];
            res[i][1] = t[1];
        }
        return res;
    }
}