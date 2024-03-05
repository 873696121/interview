package algorithm.leetcode.l101_200.l101_150.l_132;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 分割回文串 II
 ***********************************************************/
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        s = " " + s;
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= i; j ++) {
                if(isPara(s.substring(j, i + 1))) f[i] = Math.min(f[i], f[j - 1] + 1);
            }
        }
        // System.out.println(Arrays.toString(f));
        return f[n] - 1;
    }

    boolean isPara(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i ++;
            j --;
        }
        return true;
    }
}