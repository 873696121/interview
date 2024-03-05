package algorithm.leetcode.l301_400.l301_350.l_306;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 306. 累加数
 ***********************************************************/
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i = 0; i < n; i ++) {
            for(int j = i + 1; j < n - 1; j ++) {
                String a = num.substring(0, i + 1), b = num.substring(i + 1, j + 1);
                int start = j + 1;
                boolean flag = true;
                while(true) {
                    if(!judge(a) || !judge(b)) {
                        flag = false;
                        break;
                    }
                    String c = add(a, b);
                    int end = start + c.length();
                    // if(k <= n) c = nums.substring()
                    if(end > n || !c.equals(num.substring(start, end))) {
                        flag = false;
                        break;
                    }
                    if(end == n){
                        System.out.println(i + " " + j + " " + a + " " + b);
                        return true;
                    }
                    a = b;
                    b = c;
                    start = end;
                }
                if(!flag) continue;
                else {
                    return true;
                }
            }
        }
        // System.out.println(add("12", "23"));
        return false;
    }

    boolean judge(String s) {
        if(s.length() > 1) return !s.startsWith("0");
        return true;
    }

    String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        for(int i = 0, k = 0; i < a.length() || i < b.length() || k > 0; i ++) {
            if(i < a.length()) k += a.charAt(i) - '0';
            if(i < b.length()) k += b.charAt(i) - '0';
            sb.append(k % 10);
            k /= 10;
        }
        return sb.reverse().toString();
    }
}