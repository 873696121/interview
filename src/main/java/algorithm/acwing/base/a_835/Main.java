package algorithm.acwing.base.a_835;

import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: Trie字符串统计
 ***********************************************************/
public class Main {
    final static int N = 1000100;
    static int[][] f = new int[N][26];
    static int idx = 0;
    static int[] st = new int[N];

    static void insert(String s) {
        int p = 0;
        for(int i = 0; i < s.length(); i ++){
            int t = s.charAt(i) - 'a';
            if(f[p][t] == 0) f[p][t] = ++idx;
            p = f[p][t];
        }
        st[p] ++;
    }

    static int query(String s) {
        int p = 0;
        for(int i = 0; i < s.length(); i ++){
            int t = s.charAt(i) - 'a';
            if(f[p][t] == 0) return 0;
            p = f[p][t];
        }
        return st[p];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n -- > 0) {
            String op = sc.next();
            String str = sc.next();
            if("I".equals(op)) insert(str);
            else System.out.println(query(str));
        }
    }
}
