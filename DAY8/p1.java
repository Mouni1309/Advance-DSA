// Problem: Word Break Problem
import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        int n = sc.nextInt();
        sc.nextLine();
        
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine().toLowerCase();
            trie.insert(word);
        }
        
        boolean result = trie.isWordBreak(s);
        System.out.println(result ? "YES" : "NO");
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    static class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch < 'a' || ch > 'z') continue;
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }
        
        public boolean isWordBreak(String s) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true; // empty string
            
            for (int i = 0; i <= n; i++) {
                if (!dp[i]) continue;
                
                TrieNode current = root;
                for (int j = i; j < n; j++) {
                    char ch = s.charAt(j);
                    if (ch < 'a' || ch > 'z') break;
                    int index = ch - 'a';
                    if (current.children[index] == null) {
                        break;
                    }
                    current = current.children[index];
                    if (current.isEndOfWord) {
                        dp[j + 1] = true;
                    }
                }
            }
            
            return dp[n];
        }
    }
}