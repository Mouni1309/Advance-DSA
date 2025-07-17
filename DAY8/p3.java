// distibuted chocolates to children
import java.util.*;
public class p3{
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        if(arr==null || arr.isEmpty() || m==0 || m>arr.size()){
            return 0;
        }
        Collections.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<=arr.size()-m;i++){
            int diff=arr.get(i+m-1)-arr.get(i);
            minDiff=Math.min(minDiff,diff);
        }
        return minDiff;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        p3 solution = new p3();
        int result = solution.findMinDiff(arr, m);
        System.out.println(result);
    }
}