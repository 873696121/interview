package algorithm.leetcode.l1_100.l51_100.l_58;

/***********************************************************                                          *
 * Time: 2022/5/19
 * Author: HuHong
 * Desc: 最后一个单词的长度
 ***********************************************************/
class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length - 1].length();
    }
}