// collect max no of coins without visiting adjacent houses
import java.util.*;
class p4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
        	int size=sc.nextInt();
            
	        int a[]=new int[size];

	        for(int j=0;j<size;j++)
	            a[j]=sc.nextInt();

        	System.out.println(maxsum(a,size));
        }
    }
    public static int maxsum(int a[],int n){
        int dp[] =new int[n+1];
        dp[1]=a[0];
        for(int i=2;i<=n;i++){
       	dp[i]=Math.max(dp[i-2]+a[i-1],dp[i-1]);
        }
        return dp[n];
    }
}