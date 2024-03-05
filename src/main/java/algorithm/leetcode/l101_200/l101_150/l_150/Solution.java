package algorithm.leetcode.l101_200.l101_150.l_150;

import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/5/11
 * Author: HuHong
 * Desc: 逆波兰表达式求值
 ***********************************************************/
class Solution {
    Stack<String> st = new Stack<>();

    boolean isCal(String t) {
        return "+".equals(t) || "-".equals(t) || "*".equals(t) || "/".equals(t);
    }

    String eval(){
        if(st.size() > 0 && !isCal(st.peek()))
            return st.pop();
        String op = st.pop();
        int b = Integer.parseInt(eval());
        int a = Integer.parseInt(eval());
        int c;
        if("+".equals(op)) {
            c = a + b;
        }else if("-".equals(op)) {
            c = a - b;
        }else if("*".equals(op)) {
            c = a * b;
        }else {
            c = a / b;
        }
        return String.valueOf(c);
    }

    public int evalRPN(String[] tokens) {
        for(int i = 0; i < tokens.length; i ++)
            st.push(tokens[i]);
        return Integer.parseInt(eval());
    }
}