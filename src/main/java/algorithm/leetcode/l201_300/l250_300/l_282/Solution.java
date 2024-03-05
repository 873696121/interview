package algorithm.leetcode.l201_300.l250_300.l_282;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 282. 给表达式添加运算符
 * review
 ***********************************************************/
class Solution {
    List<String> res = new ArrayList<>();
    char[] path = new char[100];
    String num;
    int target;
    public List<String> addOperators(String _num, int _target) {
        num = _num;
        target = _target;
        dfs(0, 0, 0, 1);
        return res;
    }

    void dfs(int u, int len, long a, long b) {
        if(u == num.length()) {
            if(a == target) res.add(new String(path, 0, len - 1));
            return;
        }
        long c = 0;
        for(int i = u; i < num.length(); i ++){
            c = c * 10 + num.charAt(i) - '0';
            path[len++] = num.charAt(i);
            path[len] = '+';
            dfs(i + 1, len + 1, a + b * c, 1);
            if(i < num.length() - 1) {
                path[len] = '-';
                dfs(i + 1, len + 1, a + b * c, -1);
                path[len] = '*';
                dfs(i + 1, len + 1, a, b * c);
            }
            if(num.charAt(u) == '0') break;
        }
    }
}