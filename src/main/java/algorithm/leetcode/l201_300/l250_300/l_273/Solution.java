package algorithm.leetcode.l201_300.l250_300.l_273;

/***********************************************************                                          *
 * Time: 2022/6/30
 * Author: HuHong
 * Desc: 273. 整数转换英文表示
 * review
 ***********************************************************/
class Solution {
    String[] num1_19 = new String[]{
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    String[] num20_90 = new String[]{
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    String[] num1000 = new String[]{
            "Billion ", "Million ", "Thousand ", ""
    };

    String get(int num) {// 返回1-999
        StringBuilder sb = new StringBuilder();
        if(num / 100 > 0) {
            sb.append(num1_19[num / 100]).append(" Hundred ");
            num -= (num / 100) * 100;
        }
        if(num >= 20) {
            sb.append(num20_90[num / 10]).append(" ");
            num -= (num / 10) * 10;
            sb.append(num1_19[num]);
        }
        else  {
            sb.append(num1_19[num]);
        }
        if(sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for(int i = (int)(1e9), j = 0; i > 0; i /= 1000) {
            if(num >= i) {
                int t = num / i;
                sb.append(get(t)).append(" ").append(num1000[j]);
                num -= t * i;
            }
            j++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}