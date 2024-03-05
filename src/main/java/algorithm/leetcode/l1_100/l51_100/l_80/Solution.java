package algorithm.leetcode.l1_100.l51_100.l_80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0, pre = -1, cnt = 0; i < nums.length; i ++){
            if(nums[i] == pre) {
                cnt ++;
                if(cnt > 2) continue;
            }else {
                pre = nums[i];
                cnt = 1;
            }
            swap(nums, i, j);
            j ++;
        }
        return j;
    }

    void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}