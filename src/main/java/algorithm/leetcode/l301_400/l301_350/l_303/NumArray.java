package algorithm.leetcode.l301_400.l301_350.l_303;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 303. 区域和检索 - 数组不可变
 ***********************************************************/
class NumArray {

    int[] f = new int[10010];
    public NumArray(int[] nums) {
        for(int i = 1; i <= nums.length; i ++) {
            f[i] = f[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return f[right + 1] - f[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */