// Problem: Given an array of 0s and 1s, find the length of the longest subarray with equal number of 0s and 1s.
import java.util.*;
class p1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(maxLen(a,n));
    }
    // public static int maxLen(int a[], int n){
    //     int max=0;
    //     for(int i=0;i<n;i++){
    //         int c1=0, c2=0;
    //         for(int j=i;j<n;j++){
    //             if(a[j]== 0)
    //                 c1++;
    //             else if(a[j]== 1)
    //                 c2++;
    //             if(c1==c2)
    //                 max=Math.max(max, j-i+1);
    //         }
    //     }
    //     return max;
    // }
    public static int maxLen(int a[],int n){
        int max=0;
        for(int i=0;i<n;i++){
            int s=0;
            for(int j=i;j<n;j++){
                if(a[j]==0)
                    s-=1;
                else if(a[j]==1)
                    s+=1;
                if(s==0)
                    max=Math.max(max, j-i+1);
            }
        }
        return max;
    }
}