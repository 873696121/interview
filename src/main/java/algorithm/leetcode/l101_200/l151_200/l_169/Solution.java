package algorithm.leetcode.l101_200.l151_200.l_169;

/***********************************************************                                          *
 * Time: 2022/5/24
 * Author: HuHong
 * Desc: 多数元素
 ***********************************************************/
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, res = Integer.MAX_VALUE;
        for(int x : nums) {
            if(x == res) cnt ++;
            else {
                cnt --;
                if(cnt < 0) {
                    cnt = 1;
                    res = x;
                }
            }
        }
        return res;
    }
}