package algorithm.leetcode.l1_100.l1_50.l_20;

import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 有效的括号
 ***********************************************************/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length();  i++){
            char t = s.charAt(i);
            if(t == '(' || t =='[' || t == '{') st.push(t);
            else {
                if(st.isEmpty()) return false;
                if(Math.abs(st.peek() - t) <= 4) st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}