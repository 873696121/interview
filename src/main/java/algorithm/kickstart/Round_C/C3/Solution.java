package algorithm.kickstart.Round_C.C3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    static class Node{
        int position;
        int direction;

        public Node(int position, int direction) {
            this.position = position;
            this.direction = direction;
        }

        public void move(){
            if(direction == 0) position --;
            else position ++;
        }
    }

    int n, L;
    void solve() {
        n = sc.nextInt();
        L = sc.nextInt();
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            int p = sc.nextInt(), d = sc.nextInt();
            list.add(new Node(p, d));
        }
        while(list.size() > 0) {
            for(int i = 0; i < list.size(); i ++){
                list.get(i).move();
            }
            int length = list.size();
            for(int i = 0; i < list.size(); i ++){
                if(list.get(i).position == -1 || list.get(i).position == length) list.remove(list.get(i));
            }
            for(int i = 0; i < list.size(); i ++){
                for(int j = i + 1; j < list.size(); j ++){
                    Node p = list.get(i), q = list.get(j);
                    if(p.direction != q.direction && (p.position == q.position)) {

                    }
                }
            }
        }
    }




    void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            solution.solve();
        }
    }
}
