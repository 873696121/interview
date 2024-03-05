package algorithm.kickstart.Round_D.D2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    int n, X, Y;

    void solve() {
        n = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        int total = (n + 1) * n / 2;
        if (total % (X + Y) != 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        int target = total / (X + Y) * X;
        boolean[][] f = new boolean[n + 10][target + 10];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= i) f[i][j] |= f[i - 1][j - i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            if (target - i >= 0 && f[i - 1][target - i]) {
                target -= i;
                list.add(i);
            }
        }
        Collections.reverse(list);
        System.out.println("POSSIBLE");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
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
