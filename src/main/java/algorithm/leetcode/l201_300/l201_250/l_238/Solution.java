package algorithm.leetcode.l201_300.l201_250.l_238;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 238. 除自身以外数组的乘积
 ***********************************************************/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n], r = new int[n];
        for(int i = 0; i < n; i ++) {
            if(i == 0) l[i] = nums[i];
            else l[i] = l[i - 1] * nums[i];
        }
        for(int i = n - 1; i >= 0; i --){
            if(i == n - 1) r[i] = nums[i];
            else r[i] = r[i + 1] * nums[i];
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i ++) {
            res[i] = 1;
            if(i > 0) res[i] *= l[i - 1];
            if(i < n - 1) res[i] *= r[i + 1];
        }
        // System.out.println(Arrays.toString(l));
        // System.out.println(Arrays.toString(r));
        return res;
    }
}