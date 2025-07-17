// counts the number of contiguous subarrays whose sum multiplied by their length is less than a given value k.
import java.util.Scanner;

class p4{
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
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                int l=j-i+1;
                if(sum*l<k) c++;
                else break;
            }
        }
        return c;
    }
}