package algorithm.leetcode.l201_300.l250_300.l_300;

import java.util.ArrayList;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 300. 最长递增子序列
 ***********************************************************/
//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] f = new int[n];
//        int res = 0;
//        for(int i = 0; i < n; i ++){
//            f[i] = 1;
//            for(int j = 0; j < i; j ++) {
//                if(nums[i] > nums[j]) f[i] = Math.max(f[i], f[j] + 1);
//            }
//            res = Math.max(res, f[i]);
//        }
//        return res;
//    }
//}

class Solution {
    // 贪心二分法  nlogn
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> q = new ArrayList<>();
        for(int t : nums) {
            if(q.size() == 0 || t > q.get(q.size() - 1)) q.add(t);
            else {
                int l = 0, r = q.size() - 1;
                while(l < r) {
                    int mid = l + r >> 1;
                    // 1 3 5
                    // 4
                    // 1 3 4
                    if(q.get(mid) >= t) r = mid;
                    else l = mid + 1;
                }
                q.set(l, t);
            }
        }
        return q.size();
    }
}