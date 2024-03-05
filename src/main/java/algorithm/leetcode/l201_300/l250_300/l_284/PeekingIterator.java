package algorithm.leetcode.l201_300.l250_300.l_284;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 284. 顶端迭代器
 ***********************************************************/
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> q = new LinkedList<>();
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()) q.offer(iterator.next());
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return q.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return q.size() > 0;
    }
}