// implements a Trie (prefix tree) and provides a method to find the maximum number of times any prefix of a given word appears as a complete word in the trie.
import java.util.Scanner;

public class p3 {
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
        for(int i=0;i<n;i++){
            
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
        public int Maxword(String word) {
            TrieNode curr = root;
            int max = 0;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    return max;
                }
                curr = curr.children[ch - 'a'];
                max = Math.max(max, curr.w);
            }
            return max;
        }
    }

}