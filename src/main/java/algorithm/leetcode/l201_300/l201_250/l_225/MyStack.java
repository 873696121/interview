package algorithm.leetcode.l201_300.l201_250.l_225;

import java.util.LinkedList;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 225. 用队列实现栈
 ***********************************************************/
class MyStack {

    Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    public int top() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        q2.offer(res);
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */