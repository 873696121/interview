package algorithm.leetcode.l1_100.l51_100.l_67;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 二进制求和
 ***********************************************************/
class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder res = new StringBuilder();
        for(int i = 0, t = 0; i < a.length() || i < b.length() || t > 0; i ++) {
            if(i < a.length()) t += a.charAt(i) - '0';
            if(i < b.length()) t += b.charAt(i) - '0';
            res.append(t % 2);
            t /= 2;
        }
        return res.reverse().toString();
    }
}