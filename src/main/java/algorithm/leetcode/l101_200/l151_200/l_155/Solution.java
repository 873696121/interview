package algorithm.leetcode.l101_200.l151_200.l_155;

import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/5/22
 * Author: HuHong
 * Desc: 最小栈
 ***********************************************************/
class MinStack {

    Stack<Integer> st, stMin;
    public MinStack() {
        st = new Stack<>();
        stMin = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        int t = val;
        if(stMin.size() > 0) t = Math.min(t, stMin.peek());
        stMin.push(t);
    }

    public void pop() {
        st.pop();
        stMin.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return stMin.peek();
    }
}