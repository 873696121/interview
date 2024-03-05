package algorithm.acwing.base.a_830;

import java.util.Scanner;
import java.util.Stack;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 单调栈
 ***********************************************************/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++) {
            q[i] = sc.nextInt();
            while(st.size() > 0 && q[st.peek()] >= q[i]) st.pop();
            if(st.empty()) System.out.print("-1 ");
            else System.out.print(q[st.peek()] + " ");
            st.push(i);
        }
    }
}
