package algorithm.leetcode.l1_100.l51_100.l_60;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 排列序列
 * review
 ***********************************************************/
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        boolean[] st = new boolean[n + 1];
        for(int i = 1; i <= n; i ++){
            int fact = 1;
            for(int j = n - i; j >= 1; j --) fact *= j;
            for(int j = 1; j <= n; j ++){
                if(!st[j]) {
                    if(k > fact) k-= fact;
                    else {
                        res.append(j);
                        st[j] = true;
                        break;
                    }
                }
            }
        }
        return res.toString();
    }
}