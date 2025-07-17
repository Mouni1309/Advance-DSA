// Find the starting station index from which you can complete the circuit once (if possible). If not possible, return -1.
import java.util.*;
class p1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int gas[]=new int[n];
        for(int i=0;i<n;i++)
            gas[i]=sc.nextInt();
        int cost[]=new int[n];
        for(int i=0;i<n;i++)
            cost[i]=sc.nextInt();
        System.out.println(find(gas,cost));
    }
    public static int find(int[] gas, int cost[]){
        int start = 0;
        int curr = 0;
        int total = 0;
        for(int i = 0;i < gas.length; i++) {
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(curr < 0){
                start =  i + 1;
                curr = 0;
            }
        }
        if(total < 0)
            return -1;
        return start;
    }
}