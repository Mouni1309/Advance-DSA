// Problem: Count Distinct Subsequences
import java.util.*;
public class p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(dseq(s1, s2));
    }
    public static int dseq(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0]=1;
        for(int i=0;i<=m;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(s1.charAt(j)==s2.charAt(i)){
                    dp[i+1][j+1]=dp[i][j]+dp[i+1][j];
                }
                else{
                    dp[i+1][j+1]=dp[i+1][j];
                }
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}

