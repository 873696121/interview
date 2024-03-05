package algorithm.leetcode.l1_100.l1_50.l_12;

class Solution {
    static int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] roms = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < nums.length && num > 0; i ++) {
            while(num >= nums[i]) {
                num -= nums[i];
                sb.append(roms[i]);
            }
        }
        return sb.toString();
    }
}