package algorithm.leetcode.l201_300.l201_250.l_228;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/6/27
 * Author: HuHong
 * Desc: 228. 汇总区间
 ***********************************************************/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int pre = 0;
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        for(int i = 0; i < nums.length; i ++){
            if(i == 0) pre = nums[i];
            else {
                if(nums[i] == nums[i - 1] + 1) continue;
                else {
                    String t = String.valueOf(pre);
                    if(pre != nums[i - 1]) {
                        t = String.valueOf(pre) + "->" + nums[i - 1];
                    }
                    res.add(t);
                    pre = nums[i];
                }
            }
        }
        String t = String.valueOf(pre);
        if(pre != nums[n - 1]) {
            t = String.valueOf(pre) + "->" + nums[n - 1];
        }
        res.add(t);
        return res;
    }
}