// implements the Boyer-Moore pattern matching algorithm using the bad character heuristic.
import java.util.*;
public class p1{
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        String text=sc.next();
        String p=sc.next();
        BoyerMoore(text, p);
    }
    public static void BoyerMoore(String text, String p){
     int m = p.length();
     int n = text.length();
     int bc[] = new int[256];
     BadCharacterHeuristic(p,m,bc);
     int i=0;
     while(i<=(n-m)){
         int j=m-1;
         while(j>=0 && p.charAt(j) == text.charAt(i+j)){
             j--;
         }
         if(j<0){
             System.out.println("Pattern found at index "+i);
             if(i<n-m)
                 i=i+m-bc[(int)text.charAt(i+m)];
             else
                 i=i+1;
         }
         else{
             i=i+m-j-bc[(int)text.charAt(i+j)];
         }
     }
 }
 public static void BadCharacterHeuristic(String p,int m, int bc[]){
     for(int i=0;i<256;i++)
         bc[i]=-1;
     for(int i=m-1;i>=0;i--)
         bc[(int)p.charAt(i)]=i;
 }
}