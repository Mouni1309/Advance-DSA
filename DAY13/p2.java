// perfect sqares
import java.util.*;
class p2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(countSquares(n));
    }
    public static int countSquares(int n){
        int a[]=new int[(int)Math.sqrt(n)+1];
        for(int i=1;i<=Math.sqrt(n);i++){
            a[i]=i*i;
        }
        for(int i=0;i<Math.sqrt(n);i++){
            System.out.println(a[i]);
        }
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<=Math.sqrt(i);j++){
                if(a[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-a[j]]+1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}