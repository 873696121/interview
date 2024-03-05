package algorithm.acwing.base.a_3302;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 表达式求值
 ***********************************************************/
public class Main {

    static Map<Character, Integer> pr = new HashMap<>();
    static String s;
    static Stack<Integer> num = new Stack<>();
    static Stack<Character> op = new Stack<>();

    static void eval() {
        int b = num.pop();
        int a = num.pop();
        char t = op.pop();
        int c;
        if (t == '+') c = a + b;
        else if (t == '-') c = a - b;
        else if (t == '*') c = a * b;
        else c = a / b;
        num.push(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        pr.put('+', 1);
        pr.put('-', 1);
        pr.put('*', 2);
        pr.put('/', 2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') op.push(c);
            else if (Character.isDigit(c)) {
                int j = i, t = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    t = t * 10 + s.charAt(j) - '0';
                    j++;
                }
                num.push(t);
                i = j - 1;
            } else if (c == ')') {
                while(!op.empty() && op.peek() != '(') eval();
                op.pop();
            }else {
                while(!op.empty() && op.peek() != '(' && pr.get(op.peek()) >= pr.get(c)) eval();
                op.push(c);
            }
        }
        while(!op.empty()) eval();
        System.out.println(num.peek());
    }
}
