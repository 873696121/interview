package algorithm.leetcode.l1_100.l51_100.l_81;

class Solution {
    public boolean search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (R > 0 && nums[R] == nums[L]) R--;
        if (nums[R] < nums[L]) {
            int l = L, r = R;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < nums[0]) r = mid;
                else l = mid + 1;
            }
            if (target < nums[0]) {
                L = l;
                R = nums.length - 1;
            } else {
                L = 0;
                R = l - 1;
            }
        }
        int l = L, r = R;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l] == target;
    }
}