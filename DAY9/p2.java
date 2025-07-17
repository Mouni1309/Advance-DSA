// solves the "Frog Jump with K Distance" problem using dynamic programming.
import java.util.Scanner;

public class p2 {

    public static int minCost(int[] height, int n, int k) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int cost = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Enter the height of each stair:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println("Minimum cost: " +minCost(height, n, k));
    }
}