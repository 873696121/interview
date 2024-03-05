package algorithm.leetcode.l101_200.l151_200.l_165;

/***********************************************************                                          *
 * Time: 2022/5/24
 * Author: HuHong
 * Desc: 比较版本号
 ***********************************************************/
class Solution {
    public int compareVersion(String version1, String version2) {
        return compareVersion(version1.split("\\."), version2.split("\\."));
    }

    public int compareVersion(String[] v1, String[] v2) {
        if (v1.length > v2.length) {
            return compareVersion(v2, v1) * -1;
        }
        int i = 0;
        for (; i < v1.length; i++) {
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            if(a > b) return 1;
            if(a < b) return -1;
        }
        while (i < v2.length) {
            if(Integer.parseInt(v2[i]) != 0) return -1;
            i++;
        }
        return 0;
    }
}