package algorithm.leetcode.l201_300.l250_300.l_278;

/***********************************************************                                          *
 * Time: 2022/7/1
 * Author: HuHong
 * Desc: 278. 第一个错误的版本
 ***********************************************************/

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (int) ((long) l + r >> 1);
            if (isBadVersion((int) mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}