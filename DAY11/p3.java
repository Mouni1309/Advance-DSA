// This code implements a wildcard pattern matching algorithm that checks if a string matches a given pattern with wildcards.
// The pattern can contain '?' which matches any single character and '*' which matches any sequence of characters
// The algorithm uses dynamic programming to build a table that tracks matches between the string and the pattern.
// It returns true if the string matches the pattern, otherwise false.

import java.util.*;
public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(wcpm(s1,s2));
    }
    public static boolean wcpm(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            if(s2.charAt(i-1)=='*') {
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) ||s2.charAt(j-1)=='?') {
                    dp[i][j] = dp[i-1][j-1];
                }else if(s2.charAt(j-1)=='*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
    
                }
            }
        }
        return dp[m][n];
    }        
}