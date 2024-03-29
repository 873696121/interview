package algorithm.leetcode.l1_100.l1_50.l_11;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int res = 0;
        while(i <= j) {
            System.out.println(height[i] + " " + height[j] + " " + (j - i));
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if(height[i] < height[j]) i ++;
            else j --;
        }
        return res;
    }
}