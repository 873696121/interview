package algorithm.kickstart.model.myModel;

import java.util.Scanner;

public class Solution {


    void solve() {

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
