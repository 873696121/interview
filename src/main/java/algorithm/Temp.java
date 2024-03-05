package algorithm;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc:
 ***********************************************************/
public class Temp {
    static long quickPow(long a, long b, long p) {
        long res = 1;
        while(b > 0) {
            if((b & 1) != 0) res = (res * a) % p;
            a *= a;
            a %= p;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aba";
        int i = 2;
        String t = s.substring(0, i) + s.substring(i + 1);
        System.out.println(t);
    }
}
