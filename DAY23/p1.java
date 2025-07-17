// develop a program to print all occurances of pattern p in text t using rabin karp algorithm
import java.util.*;
public class p1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String p=sc.nextLine();
        int d=256;
        int q=101;
        SearchRabinKarp(text,p,d,q);
    }
    public static void SearchRabinKarp(String text, String pat, int d, int q){
        int m = pat.length();
        int n = text.length();
        int h=1, p=0, t=0;
        for(int i=0;i<m-1;i++){
            h=(h*d)%q;
        }
        for(int i=0;i<m;i++){
            p=(d*p+(int)pat.charAt(i))%q;
            t=(d*t+(int)text.charAt(i))%q;
        }
        int j;
        for(int i=0;i<= n-m;i++){
            if(p==t){
                for( j=0;j<m;j++){
                    if(text.charAt(i+j)!=pat.charAt(j))
                        break;
                }
                if(j==m)
                    System.out.println("Pattern found at index "+i);
            }
            if(i<n-m){
                t=(d*(t-(int)text.charAt(i)*h)+text.charAt(i+m))%q;
                if(t<0)
                t=t+q;
            }
        }
    }
}