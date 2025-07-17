// This code finds the length of the longest square sub-matrix with all 1s in a given binary matrix.
import java.util.Scanner;

public class p4 {
    static int lensub(int[][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        int dp[][] =new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || mat[i][j]==0)
                    dp[i][j]=mat[i][j];
                else {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
                }
                ans+=dp[i][j];
            }
        return ans;
    }
    public static void main(String[] args) {
        int [][]mat=new int[3][4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<4;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println(lensub(mat));
        
    }
}