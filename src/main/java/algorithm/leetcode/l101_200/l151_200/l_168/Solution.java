package algorithm.leetcode.l101_200.l151_200.l_168;

/***********************************************************                                          *
 * Time: 2022/5/24
 * Author: HuHong
 * Desc: Excel表列名称
 * review
 ***********************************************************/
class Solution {
    public String convertToTitle(int t) {
        StringBuffer sb = new StringBuffer();
        while(t > 0) {
            // 要-1
            t --;
            char c = (char)('A' + t % 26);
            sb.append(c);
            t -= t % 26;
            t /= 26;
        }
        return sb.reverse().toString();
    }
}