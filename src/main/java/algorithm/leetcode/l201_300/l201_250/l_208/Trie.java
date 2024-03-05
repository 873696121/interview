package algorithm.leetcode.l201_300.l201_250.l_208;

/***********************************************************                                          *
 * Time: 2022/6/25
 * Author: HuHong
 * Desc: 208. 实现 Trie (前缀树)
 ***********************************************************/
class Trie {

    static int N = 100010;
    int [][] f = new int[N][26];
    int idx = 0;
    int[] cnt = new int[N];

    public Trie() {

    }
    
    public void insert(String word) {
        int p = 0;
        for(int i = 0; i < word.length(); i ++) {
            char t = word.charAt(i);
            int u = t - 'a';
            if(f[p][u] == 0) f[p][u] = ++idx;
            p = f[p][u];
        }
        cnt[p] ++;
    }
    
    public boolean search(String word) {
        int p = 0;
        for(int i = 0; i < word.length(); i ++){
            int u = word.charAt(i) - 'a';
            if(f[p][u] == 0) return false;
            p = f[p][u];
        }
        return cnt[p] > 0;
    }
    
    public boolean startsWith(String prefix) {
        int p = 0;
        for(int i = 0; i < prefix.length(); i ++){
            int u = prefix.charAt(i) - 'a';
            if(f[p][u] == 0) return false;
            p = f[p][u];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */