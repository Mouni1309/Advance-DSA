// find nth catalan number
import java.util.*;

class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (n == 0) {
            System.out.println(dp[0]);
        } else {
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
