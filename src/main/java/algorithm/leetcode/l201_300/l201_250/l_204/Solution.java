package algorithm.leetcode.l201_300.l201_250.l_204;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 204. 计数质数
 ***********************************************************/
class Solution {
    public int countPrimes(int n) {
        boolean[] f = new boolean[n + 10];
        int res = 0;
        for(int i = 2; i < n; i ++){
            if(!f[i]) {
                res ++;
                for(int j = i; j < n; j += i) f[j] = true;
            }
        }
        return res;
    }
}