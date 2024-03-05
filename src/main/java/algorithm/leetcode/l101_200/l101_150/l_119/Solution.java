package algorithm.leetcode.l101_200.l101_150.l_119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/9
 * Author: HuHong
 * Desc: 杨辉三角 II
 ***********************************************************/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i = 1; i <= rowIndex; i ++)
            res = tran(res);
        return res;
    }

    List<Integer> tran(List<Integer> list) {
        if(list.size() == 1) {
            return Arrays.asList(1, 1);
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i = 1; i < list.size(); i ++){
            res.add(list.get(i) + list.get(i - 1));
        }
        res.add(1);
        return res;
    }
}