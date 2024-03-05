package algorithm.kickstart.Round_C.C1;

import java.util.Scanner;

public class Solution {

    int n;
    String s;
    void solve() {
        n = sc.nextInt();
        s = sc.next();
        boolean a = false, b = false, c = false, d = false;
        for(int i = 0; i < s.length(); i ++){
            char t = s.charAt(i);
            if(Character.isUpperCase(t)) a = true;
            if(Character.isLowerCase(t)) b = true;
            if(Character.isDigit(t)) c = true;
            if(t == '#' || t == '@' || t == '*' || t == '&') d = true;
        }
        if(!a) s += 'A';
        if(!b) s += 'a';
        if(!c) s += '0';
        if(!d) s += '#';
        while(s.length() < 7) s += '0';
        System.out.println(s);
    }

    int tran(boolean c) {
        if(c) return 1;
        return 0;
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
