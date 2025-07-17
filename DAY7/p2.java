// implements a Trie (prefix tree) that supports:

// Inserting words (with duplicate counts)
// Searching for a word
// Counting the number of times a word was inserted
// Checking if a prefix exists
// Counting how many words start with a given prefix


import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie t=new Trie();
        System.out.println("Enter number of words to insert:");
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String word = sc.next();
            t.insert(word);
        }
        String s1=sc.next();
        if(t.search(s1)) {
            System.out.println("Word found in trie");
            System.err.println("Count of word: " + t.csearch(s1));
        } else {
            System.out.println("Word not found in trie");
        }
        String s2=sc.next();
        if(t.prefix(s2)) {
            System.out.println("Prefix found in trie");
            System.err.println("Count of prefix: " + t.cprefix(s2));
        } else {
            System.out.println("Prefix not found in trie");
        }
    }
    static class TrieNode {
        TrieNode[] children;
        boolean isLeft; int c; int w;

        public TrieNode() {
            children = new TrieNode[26]; 
            isLeft = false;
            c=0;
        }
    }
    static class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }   
        public void insert(String word)
        {
            TrieNode curr=root;
            for(char ch : word.toCharArray())
            {
                if(curr.children[ch - 'a'] == null)
                {
                    curr.children[ch - 'a'] = new TrieNode();

                }
                curr = curr.children[ch - 'a'];
                curr.c++; 
            }
            curr.isLeft = true;
            curr.w++;
        }
        public boolean search(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.children[ch - 'a'];
            }
            return curr.isLeft;
            
        }

        public boolean prefix(String prefix) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.children[ch - 'a'];
            }
            return true;
        }

        public int csearch(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    return 0;
                }
                curr = curr.children[ch - 'a'];
            }
            if (curr.isLeft) {
                return curr.w;
            }
            return 0;
        }

        public int cprefix(String prefix) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    return 0;
                }
                curr = curr.children[ch - 'a'];
            }
            if (curr.isLeft) {
                return curr.c;
            }
            int count = 0;
            for (TrieNode child : curr.children) {
                if (child != null) {
                    count += child.c;
                }
            }
            return count;
        }
    }

}