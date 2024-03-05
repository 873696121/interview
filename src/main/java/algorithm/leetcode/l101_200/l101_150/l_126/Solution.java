package algorithm.leetcode.l101_200.l101_150.l_126;

import java.util.*;

/***********************************************************                                          *
 * Time: 2022/5/10
 * Author: HuHong
 * Desc: 单词接龙 II
 ***********************************************************/
class Solution {
    Map<String, Integer> d = new HashMap<>();
    Set<String> S = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String beginWord;
    String endWord;

    public List<List<String>> findLadders(String _beginWord, String _endWord, List<String> wordList) {
        endWord = _endWord;
        beginWord = _beginWord;
        S.addAll(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        d.put(beginWord, 0);
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
        if (d.containsKey(endWord)) {
            path.add(beginWord);
            dfs(beginWord);
        }
        return ans;
    }

    void dfs(String cur) {
        if (cur.equals(endWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < cur.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String newWord = cur.substring(0, i) + c + cur.substring(i + 1);
                if (d.containsKey(newWord) && d.get(newWord) == d.get(cur) + 1) {
                    path.add(newWord);
                    dfs(newWord);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}