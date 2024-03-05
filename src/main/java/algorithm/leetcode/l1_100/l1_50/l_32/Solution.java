package algorithm.leetcode.l1_100.l1_50.l_32;

import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/5/11
 * Author: HuHong
 * Desc: 最长有效括号
 * review
 ***********************************************************/
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(int i = 0, start = -1; i < s.length(); i ++){
            if(s.charAt(i) == '(') st.push(i);
            else {
                if(st.isEmpty()) start = i;
                else {
                    st.pop();
                    if(st.isEmpty()) res = Math.max(res, i - start);
                    else res = Math.max(res, i - st.peek());
                }
            }
        }
        return res;
    }
}