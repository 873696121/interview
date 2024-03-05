package algorithm.leetcode.l201_300.l201_250.l_241;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 241. 为运算表达式设计优先级
 ***********************************************************/
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression);
    }
    List<Integer> dfs(String e) {
        boolean flag = false;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < e.length() - 1; i ++){
            char t = e.charAt(i);
            if(t == '+' || t == '-' || t == '*' || t == '/') {
                flag = true;
                String left = e.substring(0, i), right = e.substring(i + 1, e.length());
                List<Integer> l = dfs(left), r = dfs(right);
                for(Integer a : l) {
                    for(Integer b : r) {
                        int s;
                        if(t == '+') s = a + b;
                        else if(t == '-') s = a - b;
                        else if(t == '*') s = a * b;
                        else s = a / b;
                        list.add(s);
                    }
                }
            }
        }
        if(!flag) list.add(Integer.parseInt(e));
        return list;
    }
}