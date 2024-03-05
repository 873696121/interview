package algorithm.leetcode.l1_100.l51_100.l_84;

import java.util.Stack;

class Solution {
    final static int N = 100010;
    public int largestRectangleArea(int[] heights) {
        int[] l = new int[N];
        int[] r = new int[N];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < heights.length; i ++){
            while(s.size() > 0 && heights[i] <= heights[s.peek()]) s.pop();
            if(s.empty()) l[i] = -1;
            else l[i] = s.peek();
            s.add(i);
        }
        s.clear();
        for(int i = heights.length - 1; i >= 0; i --) {
            while(s.size() > 0 && heights[i] <= heights[s.peek()]) s.pop();
            if(s.empty()) r[i] = heights.length;
            else r[i] = s.peek();
            s.add(i);
        }
        int res = 0;
        for(int i = 0; i < heights.length; i ++){
            System.out.println(heights[i] + " " + l[i] + " " + r[i]);
            res = Math.max(res, heights[i] * (r[i] - l[i] - 1));
        }
        return res;
    }
}