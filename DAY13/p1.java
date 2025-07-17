// max mex
import java.util.*;

public class p1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(maxMex(a, n, k));
    }

    public static int maxMex(int[] a, int n, int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=1;i<n+1;i++) {
            ts.add(i);
        }
        int i=0,j=0;
        int ans=Integer.MIN_VALUE;
        while(j<n){
            if(ts.contains(a[j]))
                ts.remove(a[j]);
            int ws=j-i+1;
            if(ws<k)
            j++;
            else if(ws==k){
                int mex=ts.first();
                ans=Math.max(ans,mex);
                ts.add(a[i]);
                i++;
                j++; 
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
