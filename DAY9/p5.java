// Problem: Minimum Path Sum in a rectangle grid
import java.util.*;
class p5{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(minsum(arr,n));
    }
    public static int minsum(int[][] arr, int n){
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = arr[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minPrev = dp[i-1][j];
                if (j > 0)
                    minPrev = Math.min(minPrev, dp[i-1][j-1]);
                if (j < n-1)
                    minPrev = Math.min(minPrev, dp[i-1][j+1]);
                dp[i][j] = arr[i][j] + minPrev;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            min = Math.min(min, dp[n-1][i]);
        return min;
    }
}