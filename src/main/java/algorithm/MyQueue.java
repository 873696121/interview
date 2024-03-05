package algorithm;

import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/5/21
 * Author: HuHong
 * Desc:
 ***********************************************************/
public class MyQueue<T> {

    Stack<T> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (isEmpty()) return null;
        if (s2.isEmpty()) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public T pop() {
        if (isEmpty()) return null;
        if (s2.isEmpty()) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public void offer(T t) {
        s1.push(t);
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();
        for (int i = 1; i <= 5; i++) q.offer(i);
        for (int i = 0; i < 3; i++)
            System.out.println(q.pop());
        q.offer(6);
        q.offer(7);
        while (q.size() > 0)
            System.out.println(q.pop());
    }
}
