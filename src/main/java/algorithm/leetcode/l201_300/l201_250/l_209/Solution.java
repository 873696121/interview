package algorithm.leetcode.l201_300.l201_250.l_209;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 209. 长度最小的子数组
 ***********************************************************/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < n; i ++){
            sum += nums[i];
            while(j + 1 <= i && sum - nums[j] >= target) {
                sum -= nums[j];
                j ++;
            }
            // for(int k = j; k <= i; k ++) System.out.print(nums[k] + " ");
            // System.out.println();
            if(sum >= target) res = Math.min(res, i - j + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}