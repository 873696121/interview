package algorithm.leetcode.l1_100.l1_50.l_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/4
 * Author: HuHong
 * Desc: 四数之和
 ***********************************************************/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < n; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                for(int k = j + 1, l = n - 1; k < l; k ++) {
                    if(k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while(k < l - 1 && nums[i] + nums[j] + nums[k] + nums[l - 1] >= target) l --;
                    if(k < l && nums[i] + nums[j] + nums[k] + nums[l] == target) {
//                        System.out.println(i + " " + j + " " + k + " " + l);
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }
        return res;
    }
}