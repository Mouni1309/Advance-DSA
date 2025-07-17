//  performs a naive pattern search to find all occurrences of a pattern in a given text.
import java.util.*;
class p1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String p=sc.next();
        PatternSearch(s,p);
    }
    public static void PatternSearch(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        for(int i=0;i<=n-m;i++){ // corrected condition
            String s=text.substring(i,i+m);
            if(s.equals(pattern))
                System.out.println(i+" ");
        }
    }
}