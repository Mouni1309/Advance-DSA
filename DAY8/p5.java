// find the ncr without using factorials and print n to k
import java.util.*;
public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        if (r > n) {
            System.out.println(0);
            return;
        }
        long[][] dp = new long[n + 1][r + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        for(int i=0;i<=r;i++){
            System.out.println(dp[n][i]);
        }
    }
}