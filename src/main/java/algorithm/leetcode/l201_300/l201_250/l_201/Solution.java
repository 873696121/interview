package algorithm.leetcode.l201_300.l201_250.l_201;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 201. 数字范围按位与
 ***********************************************************/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for(int i = 30; i >= 0; i --) {
            if(((left >> i) & 1) == ((right >> i) & 1)) {
                res += ((left >> i) & 1) << i;
            } else {
                break;
            }
        }
        return res;
    }
}