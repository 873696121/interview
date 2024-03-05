package algorithm.leetcode.l101_200.l101_150.l_127;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 单词接龙
 ***********************************************************/
class Solution {
    Map<String, Integer> d = new HashMap<>();
    Set<String> S = new HashSet<>();
    String beginWord;
    String endWord;

    public int ladderLength(String _beginWord, String _endWord, List<String> wordList) {
        endWord = _endWord;
        beginWord = _beginWord;
        S.addAll(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        d.put(beginWord, 1);
        while (q.size() > 0) {
            String t = q.poll();
            for (int i = 0; i < t.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String newWord = t.substring(0, i) + c + t.substring(i + 1);
                    if (S.contains(newWord) && !d.containsKey(newWord)) {
                        d.put(newWord, d.get(t) + 1);
                        q.add(newWord);
                    }
                }
            }
        }
        return d.getOrDefault(endWord, 0);
    }
}