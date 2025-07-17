// smooth decent 
import java.util.*;
class p3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(smoothdecent(a,n));        
    }
    public static int smoothdecent(int[] a,int n){
        int total=0;
        int c=1;
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]-1)
                c++;
            else {
                if (c>1) total+=((int)Math.pow(2,c))-1;
                c=1;
            }
        }
        if(c>1)
            total+=((int)Math.pow(2,c))-1;
        return total;
    }
}