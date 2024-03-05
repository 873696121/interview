package algorithm.leetcode.l201_300.l250_300.l_299;

import java.util.Arrays;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 299. 猜数字游戏
 ***********************************************************/
class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        int cnt = 0;
        for(int i = 0;  i < secret.length(); i ++) {
            if(secret.charAt(i) == guess.charAt(i)) cnt ++;
            else {
                a.append(secret.charAt(i));
                b.append(guess.charAt(i));
            }
        }
        char[] ca = a.toString().toCharArray(), cb = b.toString().toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        int cnt2 = 0;
        int i = 0, j = 0;
        while(i < ca.length && j < cb.length) {
            if(ca[i] == cb[j]) {
                cnt2 ++;
                i ++;
                j ++;
            }else {
                if(ca[i] < cb[j]) i++;
                else j ++;
            }
        }
        return cnt + "A" + cnt2 + "B";
    }
}