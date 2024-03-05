package algorithm.leetcode.l201_300.l250_300.l_295;

import java.util.PriorityQueue;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 295. 数据流的中位数
 ***********************************************************/
class MedianFinder {

    PriorityQueue<Integer> qMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> qMin = new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        qMin.offer(num);
        if(qMin.size() - qMax.size() > 1) {
            qMax.offer(qMin.poll());
        }
        if(qMax.size() > 0 && qMax.peek() > qMin.peek()) {
            int a = qMax.poll(), b = qMin.poll();
            qMax.offer(b);
            qMin.offer(a);
        }
    }

    public double findMedian() {
        // System.out.println(Arrays.toString(qMin.toArray()));
        // System.out.println(Arrays.toString(qMax.toArray()));
        // System.out.println();
        if(qMin.size() != qMax.size()) return qMin.peek();
        return (qMax.peek() + qMin.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */