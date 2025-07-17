// Problem: Minimum Cost Climbing Stairs
import java.util.*;
class p1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        dp[2]=Math.abs(arr[0]-arr[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+Math.abs(arr[i - 1] - arr[i-2]), dp[i-2]+Math.abs(arr[i-1] - arr[i-3]));
        }
        System.out.println(dp[n]);
    }
}