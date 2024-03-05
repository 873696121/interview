package algorithm.leetcode.l101_200.l151_200.l_151;

/***********************************************************                                          *
 * Time: 2022/5/11
 * Author: HuHong
 * Desc: 颠倒字符串中的单词
 ***********************************************************/
class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = split.length - 1; i >= 0; i --){
            if(split[i].length() > 0 && !" ".equals(split[i])) {
                sb.append(split[i] + " ");
            }
        }
        return sb.toString().trim();
    }
}