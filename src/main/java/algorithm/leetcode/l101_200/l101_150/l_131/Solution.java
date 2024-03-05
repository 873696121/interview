package algorithm.leetcode.l101_200.l101_150.l_131;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 分割回文串
 ***********************************************************/
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    void dfs(String s, int u) {
        if(u == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = u; i < s.length(); i ++){
            if(isPara(s.substring(u, i + 1))) {
                path.add(s.substring(u, i + 1));
                dfs(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPara(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i ++;
            j --;
        }
        return true;
    }
}