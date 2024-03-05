package algorithm.leetcode.l201_300.l201_250.l_239;

import java.util.Deque;
import java.util.LinkedList;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 239. 滑动窗口最大值
 ***********************************************************/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for(int i = 0; i < n; i ++){
            while(dq.size() > 0 && i - dq.peekFirst() + 1 > k) dq.pollFirst();
            while(dq.size() > 0 && nums[i] >= nums[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
            if(i - k + 1 >= 0) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
}