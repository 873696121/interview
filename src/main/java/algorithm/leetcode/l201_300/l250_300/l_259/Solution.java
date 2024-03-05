package algorithm.leetcode.l201_300.l250_300.l_259;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 260. 只出现一次的数字 III
 ***********************************************************/
class Solution {
    public int[] singleNumber(int[] nums) {
        int s = 0;
        for(int i = 0; i < nums.length; i ++) s ^= nums[i];
        System.out.println(s);
        for(int i = 0; i <= 31; i ++) {
            if(((s >> i) & 1) == 1) {
                int a = 0, b = 0;
                for(int t : nums) {
                    if(((t >> i) & 1) == 1) {
                        a ^= t;
                    }else {
                        b ^= t;
                    }
                }
                return new int[]{a, b};
            }
        }
        return new int[]{};
    }
}