package algorithm.leetcode.l101_200.l101_150.l_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 单词拆分
 ***********************************************************/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> S = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j <= i; j ++) {
                String t = s.substring(j, i + 1);
                if(S.contains(t) && (j == 0 || f[j - 1])) {
                    f[i] = true;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(f));
        return f[n - 1];
    }
}