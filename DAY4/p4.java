// the earlist movement when everyone become friends
import java.util.*;
class p4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<int[]> a=new ArrayList<>();
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int t=sc.nextInt();
            a.add(new int []{x,y,t});
        }
        int ans=earliestTime(a,n);
        System.err.print(ans);
    }
    public static int earliestTime(ArrayList<int[]> a,int n){
        int parent[]=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        Collections.sort(a,(x,y)->x[2]-y[2]);
        int n1=n;
        for(int[] a1:a){
            int x=a1[0];
            int y=a1[1];
            int t=a1[2];
            if(find(parent,x)!=find(parent,y)){
                union(parent,x,y);
                n1--;
            }
            if(n1==1) return t;
        }
        return -1;
    }
    public static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }
    public static void union(int[] parent, int i, int j) {
        int i1 = find(parent, i);
        int j1 = find(parent, j);
        parent[i1] = j1;
    }
}