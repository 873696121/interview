package algorithm.leetcode.l101_200.l101_150.l_149;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/5/11
 * Author: HuHong
 * Desc: 直线上最多的点数
 ***********************************************************/
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int vs = 0, ss = 0;
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (points[i] == points[j]) ss++;
                else if (points[j][0] == points[i][0]) vs++;
                else {
                    double k = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                    cnt.put(k, cnt.getOrDefault(k, 0) + 1);
                }
            }
            int c = vs;
            for (Double k : cnt.keySet()) {
                c = Math.max(c, cnt.get(k));
            }
            res = Math.max(res, c + ss);
        }
        return res;
    }
}