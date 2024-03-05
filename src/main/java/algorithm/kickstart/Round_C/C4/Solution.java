package algorithm.kickstart.Round_C.C4;

import java.util.*;

public class Solution {

    int n;
    String s;
    List<List<String>> list = new ArrayList<>();
    List<String> path = new ArrayList<>();

    void solve() {
        path.clear();
        list.clear();
        n = sc.nextInt();
        s = sc.next();
        dfs(s);
        int total = list.size();
        int cnt = 0;
        for (List<String> l : list) {
            for(int i = 1; i < l.size(); i ++){
                String t = l.get(i);
                if (isPa(t)) cnt++;
            }
        }
        if (total % cnt == 0) {
            System.out.println(total / cnt);
            return;
        }
        for (int i = 2; i <= cnt; i++) {
            if (total >= i && cnt >= i && total % i == 0 && cnt % i == 0) {
                total /= i;
                cnt /= i;
            }
        }
        int p = (int) (1e9 + 7);
        int res = (int) ((quickPow(total, p - 2, p) * cnt) % p);
        System.out.println(res);
    }

    long quickPow(long a, long b, long p) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % p;
            a *= a;
            a %= p;
            b >>= 1;
        }
        return res;
    }

    void dfs(String s) {
        path.add(s);
        if (s.equals("")) list.add(new ArrayList<>(path));
        for (int i = 0; i < s.length(); i++) {
            String t = s.substring(0, i) + s.substring(i + 1);
            dfs(t);
        }
        path.remove(path.size() - 1);
    }

    boolean isPa(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
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
