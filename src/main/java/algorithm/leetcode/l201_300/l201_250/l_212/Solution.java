package algorithm.leetcode.l201_300.l201_250.l_212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***********************************************************                                          *
 * Time: 2022/6/26
 * Author: HuHong
 * Desc: 212. 单词搜索 II
 ***********************************************************/
class Solution {

    private class Node {
        int id;
        Node[] son;
        Node() {
            id = -1;
            son = new Node[26];
            for(int i = 0; i < 26; i ++)
                son[i] = null;
        }
    }

    Node root = new Node();

    void insert(String word, int id) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.id = id;
    }
    static int N = 20;
    List<String> res = new ArrayList<>();
    Set<Integer> s = new HashSet<>();
    int n, m;
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    void dfs(char[][] b, int x, int y, Node p) {
        if (p.id != -1) s.add(p.id);
        char c = b[x][y];
        b[x][y] = '.';
        for (int i = 0; i < 4; i ++){
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && b[nx][ny] != '.') {
                int u = b[nx][ny] - 'a';
                if(p.son[u] != null) {
                    dfs(b, nx, ny, p.son[u]);
                }
            }
        }
        b[x][y] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        n = board.length;
        if (n == 0) return res;
        m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (root.son[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root.son[board[i][j] - 'a']);
                }
            }
        for (Integer t : s) {
            res.add(words[t]);
        }
        return res;
    }
}