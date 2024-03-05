package algorithm.leetcode.l201_300.l201_250.l_211;

/***********************************************************                                          *
 * Time: 2022/6/26
 * Author: HuHong
 * Desc: 211. 添加与搜索单词 - 数据结构设计
 ***********************************************************/
class WordDictionary {

    private class Node {
        boolean isEnd;
        Node[] son;

        Node() {
            isEnd = false;
            son = new Node[26];
            for (int i = 0; i < 26; i++) {
                son[i] = null;
            }
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++){
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    boolean dfs(String word, Node p, int i) {
        if(i == word.length()) return p.isEnd;
        if(word.charAt(i) != '.') {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) return false;
            return dfs(word, p.son[u], i + 1);
        } else {
            for(int j = 0; j < 26; j ++){
                if(p.son[j] != null) {
                    if (dfs(word, p.son[j], i + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */