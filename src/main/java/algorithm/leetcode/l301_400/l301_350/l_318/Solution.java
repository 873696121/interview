package algorithm.leetcode.l301_400.l301_350.l_318;

import java.util.HashMap;
import java.util.Map;

/***********************************************************                                          *
 * Time: 2022/7/4
 * Author: HuHong
 * Desc: 318. 最大单词长度乘积
 ***********************************************************/
class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        Map<String, Integer> hash = new HashMap<>();
        for(String s : words) {
            hash.put(s, zip(s));
        }
        for(int i = 0; i < words.length; i ++) {
            for(int j = i + 1; j < words.length; j ++) {
                if(((hash.get(words[i]) & hash.get(words[j]))) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    Integer zip(String word) {
        Map<Character, Boolean> h = new HashMap<>();
        for(int i = 0; i < word.length(); i ++) {
            h.put(word.charAt(i), true);
        }
        int res = 0;
        for(char t = 'a'; t <= 'z'; t ++) {
            if(h.getOrDefault(t, false)) res += 1 << (t - 'a');
        }
        return res;
    }
}