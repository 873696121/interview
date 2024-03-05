package algorithm.leetcode.l101_200.l151_200.l_171;

/***********************************************************                                          *
 * Time: 2022/5/24
 * Author: HuHong
 * Desc: Excel 表列序号
 ***********************************************************/
class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(int i = 0; i < columnTitle.length(); i ++) {
            char t = columnTitle.charAt(i);
            res = res * 26 + (t - 'A' + 1);
        }
        return res;
    }
}