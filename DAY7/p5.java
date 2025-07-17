// implements a Trie (prefix tree) to find the longest common prefix among a set of input strings.
import java.util.Scanner;

class TrieNode {
TrieNode child[];
boolean isLeaf;
int c,w;
TrieNode()
{
    child=new TrieNode[26];
    isLeaf=false;
    c=0;
    w=0;
}
}

 class Trie{
    TrieNode root;
    Trie(){
        root=new TrieNode();
    }
    public void insert(String key)
    {
        TrieNode curr=root;
        for(char ch:key.toCharArray())
        {
            if(curr.child[ch-'a']==null)
                curr.child[ch-'a']=new TrieNode();
            curr.child[ch-'a'].c++;
            curr=curr.child[ch-'a'];
        }
        
        curr.isLeaf=true;
        curr.w++;
    }
    //it searchs entire word
   String subs(int n,String s)
   {
         TrieNode curr=root;
         int cc=0;
         int x=0;
         String s1="";
         for(int i=0;i<25;i++)
         {
            if(curr.child[i]!=null)
            {
                cc++;
            }
         }
         if(cc!=1)
            return s1;
         else
            {   
                for(char ch:s.toCharArray())
                {
                    if(curr.child[ch-'a'].c==n)
                    {
                        s1+=ch;
                        curr=curr.child[ch-'a'];
                    }
                }
               
                

            }
             return s1;
        }   
    }
    
public class p5 {
    public static void main(String[] args) {
         Trie tr=new Trie();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s1="";
        for(int i=0;i<n;i++)
        {
            s1=sc.next();
            tr.insert(s1);
        }
        System.out.println(tr.subs(n, s1));
    }
}