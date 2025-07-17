// combinations sum
import java.util.*;
class p2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
         a[i]=sc.nextInt();
        int t=sc.nextInt();
        System.out.println(collect(a,n,t));
    }
    public static int collect(int[] a, int n, int t){
        int dp[]=new int[t+1];
        dp[0]=1;
        for(int i=1;i<=t;i++){
            for(int j=0;j<a.length;j++){
                if(i>=a[j])
                    dp[i]=dp[i]+dp[i-a[j]];
            }
        }
        return dp[t];
    }
}