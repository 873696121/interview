package algorithm.leetcode.l_6049;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static final int N = 210, M = N * N;
    int[][] f = new int[M][N];
    int idx = 0;
    Map<Integer, Boolean> st = new HashMap<>();

    public int countDistinct(int[] nums, int k, int p) {
        for (int i = 0, j = 0, cnt = 0; i < nums.length; i++) {
            if (nums[i] % p == 0) cnt++;
            while (cnt > k) {
                if (nums[j] % p == 0) cnt--;
                j++;
            }
            int t = 0;
            for (int u = i; u >= j; u--) {
                int c = nums[u];
                if (f[t][c] == 0) f[t][c] = ++idx;
                t = f[t][c];
                st.put(t, true);
            }
        }
        return st.size();
    }
}