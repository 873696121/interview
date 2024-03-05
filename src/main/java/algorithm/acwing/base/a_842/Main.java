package algorithm.acwing.base.a_842;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***********************************************************                                          *
 * Time: 2022/5/2
 * Author: HuHong
 * Desc: 排列数字
 ***********************************************************/
public class Main {
    static int n;
    static boolean[] st = new boolean[1010];
    static List<Integer> list = new ArrayList<>();
    static void dfs(int u) {
        if(u == n) {
            for(int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i ++){
            if(!st[i]) {
                st[i] = true;
                list.add(i);
                dfs(u + 1);
                list.remove(list.size() - 1);
                st[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }
}
