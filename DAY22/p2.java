// implements the Boyer-Moore pattern matching algorithm using the good suffix heuristic.

import java.util.*;
class p2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text=sc.next();
        String p=sc.next();
        BoyerMoore(text,p);
    }
    public static void BoyerMoore(String text, String p){
        int m = p.length();
        int n = text.length();
        int bpos[] = new int[m+1];
        int shift[]=new int[m+1];
        for(int i=0;i<=m;i++)
            shift[i]=0;
        strong_suffix1(shift,bpos,p,m);
        strong_suffix2(shift,bpos,p,m);
        int i=0,j;
        while(i<=(n-m)){
            j=m-1;
            while(j>=0 && p.charAt(j)==text.charAt(i+j))
                j--;
            if(j<0){
                System.out.println("Pattern found at index "+i);
                i+=shift[0];
            }
            else
                i = i +shift[j + 1];
        }
    }
    public static void strong_suffix1(int shift[],int bpos[],String p,int m){
        int i=m,j=m+1;
        bpos[i]=j;
        while(i>0){
            while(j<=m && p.charAt(i-1)!=p.charAt(j-1)){
                if(shift[j]==0)
                    shift[j]=j-i;
                j=bpos[j];
            }
            i--;
            j--;
            bpos[i]=j;
        }
    }
    public static void strong_suffix2(int shift[],int bpos[],String p,int m){
        int j;
        j=bpos[0];
        for(int i=0;i<=m;i++){
            if(shift[i]==0)
                shift[i]=j;
            if(i==j)
                j=bpos[j];
        }
    }
}