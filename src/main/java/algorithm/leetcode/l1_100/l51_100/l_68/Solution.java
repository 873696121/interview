package algorithm.leetcode.l1_100.l51_100.l_68;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 文本左右对齐
 * review
 ***********************************************************/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int j = i + 1;
            int len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder(words[i]);
            if (j == words.length || j == i + 1) {
                // 最后一排或当前只有一个单词  左对齐
                for (int k = i + 1; k < j; k++)
                    sb.append(" ").append(words[k]);
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                // 两端对齐
                int cnt = j - i - 1, total = len - cnt, blank = maxWidth - total;
                int k = 1;
                // cnt个空隙， 每个空隙有blank个空格，前 blank%cnt 个空隙多放一个空格
                while (k <= blank % cnt) {
                    sb.append(String.join("", Collections.nCopies(blank / cnt + 1, " "))).append(words[i + k]);
                    k ++;
                }
                while(k <= cnt) {
                    sb.append(String.join("", Collections.nCopies(blank / cnt, " "))).append(words[i + k]);
                    k ++;
                }
            }
            res.add(sb.toString());
            i = j - 1;
        }
        return res;
    }
}

//class Solution {
//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> res = new ArrayList<>();
//        for(int i = 0; i < words.length;){
//            int cnt = words[i].length(), cntLength = words[i].length();
//            int j = i + 1;
//            while(j < words.length && cnt + words[j].length() + 1 <= maxWidth) {
//                cnt += words[j].length() + 1;
//                cntLength += words[j].length();
//                j ++;
//            }
//            if(j == words.length) {
//                // 最后一行 左对齐
//                int cur = words[i].length();
//                StringBuilder sb = new StringBuilder(words[i]);
//                for(int k = i + 1; k < j; k ++){
//                    sb.append(" ").append(words[k]);
//                    cur += words[k].length() + 1;
//                }
//                for(int t = 0; t < maxWidth - cur; t ++) sb.append(" ");
//                res.add(sb.toString());
//            }else {
//                // 中间对齐
//                //c max / c  max % c
//                StringBuilder sb = new StringBuilder(words[i]);
//                int c = j - i - 1, total = maxWidth - cntLength;
//                for(int k = i + 1, t = 0; k < j; k ++, t ++){
//                    for(int u = 0; u < total / c; u ++) sb.append(" ");
//                    if(t < total % c) sb.append(" ");
//                    sb.append(words[k]);
//                }
//                if(c == 0)
//                    for(int k = 0; k < maxWidth - words[i].length(); k ++)
//                        sb.append(" ");
//                res.add(sb.toString());
//            }
//            i = j;
//        }
//        return res;
//    }
//}