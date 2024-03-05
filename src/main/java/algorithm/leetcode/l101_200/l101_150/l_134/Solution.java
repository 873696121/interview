package algorithm.leetcode.l101_200.l101_150.l_134;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 加油站
 ***********************************************************/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] f = new int[n * 2 + 1];
        for (int i = 0; i < n; i++)
            f[i] = f[i + n] = gas[i] - cost[i];
        int cur = 0;
        for(int i = 0, j = 0; i < f.length; i ++) {
            cur += f[i];
            while(cur < 0 && j <= i) {
                cur -= f[j];
                j ++;
            }
            if(cur >= 0 && i - j + 1 == n && j < n) return j;
        }
        return -1;
    }
}