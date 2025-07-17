// the celebrity problem
import java.util.*;
class p5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m[i][j]=sc.nextInt();
            }
        }
        int res=celebrity(m,n);
        System.err.println(res);
    }
    public static int celebrity(int m[][],int n){
        int[] ind=new int[n];
        int[] outd=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]==1 && i!=j){
                    outd[i]++;
                    ind[j]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ind[i] == n-1 && outd[i]==0) return i;
        }
        return -1;
    }
}