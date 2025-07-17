// implements the KMP (Knuth-Morris-Pratt) algorithm for efficient pattern searching in a given text.
import java.util.*;
public class p2{
    public static void computeLPS(String pattern, int m, int lps[]){
      int len=0,i=1;
      lps[0]=0;
      while(i<m){
          if(pattern.charAt(i)==pattern.charAt(len)){
              len++;
              lps[i]=len;
              i++;
          }
          else if(len!=0)
              len=lps[len-1];
          else{
              lps[i]=len;
              i++;
          }
      }
    }
    public static void kmpSearch(String text, String pat){
      int m = pat.length();
      int n = text.length();
      int lps[] = new int[m];
      computeLPS(pat, m, lps);
      int i = 0, j = 0;
      while (i<n){
          if (pat.charAt(j) == text.charAt(i)){
              i++;
              j++;
          }
          if (j == m){
              System.out.println("Found at index " + (i - j));
              j = lps[j - 1]; 
          }
          else if(i<n && pat.charAt(j) != text.charAt(i)){
              if (j != 0) 
                  j = lps[j - 1];
              else 
                  i++;
          }
      }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text = sc.nextLine();
        String pat = sc.nextLine();
        kmpSearch(text, pat);
        
    }
}