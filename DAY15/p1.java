// fruits into baskets
import java.util.*;
class p1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
         a[i]=sc.nextInt();
        System.out.println(collect(a,n));
    }
    public static int collect(int[] a, int n){
       HashMap<Integer,Integer> hm = new HashMap<>();
        int i=0, j=0, ans=0;
        while(j<n){
            hm.put(a[j], hm.getOrDefault(a[j], 0) + 1);
            while(hm.size() > 2){
                hm.put(a[i], hm.get(a[i]) - 1);
                if(hm.get(a[i]) == 0)
                    hm.remove(a[i]);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}