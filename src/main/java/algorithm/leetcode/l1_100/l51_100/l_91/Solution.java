package algorithm.leetcode.l1_100.l51_100.l_91;

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int f[] = new int[n];
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c >= '1' && c <= '9') {
                f[i] = 1;
                if(i > 0) f[i] = f[i - 1];
            }
            if(i > 0) {
                String cur = s.substring(i - 1, i + 1);
                int num = Integer.parseInt(cur);
                if(num >= 10 && num <= 26) {
                    if(i == 1) f[i] ++;
                    else f[i] += f[i - 2];
                }
            }
        }
        return f[n - 1];
    }
}