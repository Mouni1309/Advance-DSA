// This code calculates the maximum profit from stock prices given in an array, where you can buy and sell multiple times.
// The function takes an array of integers representing the stock prices and returns the maximum profit.

import java.util.*;
public class p2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(maxprofit(a, n));
    }

    public static int maxprofit(int a[], int n) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                profit += a[i] - a[i    - 1];
            }
        }
        return profit;
    }
}