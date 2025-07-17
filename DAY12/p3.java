// This code finds the length of the longest bitonic subsequence in an array.
// A bitonic subsequence is one that first increases and then decreases.
// The algorithm uses dynamic programming to calculate the longest increasing and decreasing subsequences.
// It returns the length of the longest bitonic subsequence.
import java.util.*;
class p3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(bitonic(a,n));
    }
    public static int bitonic(int[] a, int n){
        int dp[]= new int[n];
        int dp1[]= new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(dp1, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(a[i]>a[j]){
                    dp1[i]=Math.max(dp1[i], dp1[j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max, dp[i]+dp1[i]-1);
        }   
        return max;
    }
}
// 