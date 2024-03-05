package leetcode;


import java.util.Set;
import java.util.TreeSet;

class SmallestInfiniteSet {

    Set<Integer> s = new TreeSet<>();
    public SmallestInfiniteSet() {

    }
    
    public int popSmallest() {
        for(int i = 1; i <= 1010; i ++) {
            if(!s.contains(i)) {
                s.add(i);
                return i;
            }
        }
        return -1;
    }
    
    public void addBack(int num) {
        s.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */