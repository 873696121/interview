package algorithm.leetcode.l1_100.l51_100.l_89;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int k = 1; k < n; k++) {
            List<Integer> cur = new ArrayList<>(list);
            for (int i = list.size() - 1; i >= 0; i--) {
                cur.add(list.get(i) + (1 << k));
            }
            list = cur;
        }
        return list;
    }
}