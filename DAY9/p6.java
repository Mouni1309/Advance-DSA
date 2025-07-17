// Problem: Minimum Path Sum in a Triangle
import java.util.*;
class p6{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(minsum(arr,n));
    }
    public static int minsum(int[][] arr, int n){
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) continue;
                if (j == 0) {
                    dp[i][j] = arr[i][j] + dp[i-1][j];
                } else if (j == i) {
                    dp[i][j] = arr[i][j] + dp[i-1][j-1];
                } else {
                    int minPrev = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    dp[i][j] = arr[i][j] + minPrev;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            min = Math.min(min, dp[n-1][i]);
        return min;
    }
}