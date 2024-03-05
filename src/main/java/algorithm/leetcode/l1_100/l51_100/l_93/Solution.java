
package algorithm.leetcode.l1_100.l51_100.l_93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, "");
        return res;
    }

    void dfs(String s, int u, int cnt, String cur) {
        if(u == s.length()) {
            if(cnt == 4) res.add(cur.substring(0, cur.length() - 1));
            return;
        }
        int t = 0;
        for(int i = u; i < s.length(); i ++){
            if(i > u && s.charAt(u) == '0') break;
            t = t * 10 + s.charAt(i) - '0';
            if(t > 255) break;
            dfs(s, i + 1, cnt + 1, cur + t + ".");
        }
    }
}