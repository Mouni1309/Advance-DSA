// counts the number of contiguous subarrays whose product is less than a given value k.
import java.util.Scanner;

class p3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) 
            a[i]=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(countSubArrays(a,n,k));
    }
    public static int countSubArrays(int a[],int n,int k){
        int c=0;
        for(int i=0;i<n;i++){
            int p=1;
            for(int j=i;j<n;j++){
                p*=a[j];
                if(p<k) c++;
                else break;
            }
        }
        return c;
    }
}