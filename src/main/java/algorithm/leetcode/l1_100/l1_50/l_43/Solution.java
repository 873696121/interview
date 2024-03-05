package algorithm.leetcode.l1_100.l1_50.l_43;

/***********************************************************                                          *
 * Time: 2022/5/18
 * Author: HuHong
 * Desc: 字符串相乘
 ***********************************************************/
class Solution {
    public String multiply(String a, String b) {
        int n = a.length(), m = b.length();
        int[] f = new int[n + m];
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                f[i + j] += (a.charAt(i) - '0') * (b.charAt(j) - '0');
        for (int i = 0, t = 0; i < f.length; i++) {
            t += f[i];
            f[i] = t % 10;
            t /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int j : f) sb.append(j);
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}