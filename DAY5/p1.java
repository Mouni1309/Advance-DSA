// kruskals algorithm using dsu
import java.util.*;
class p1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int m=sc.nextInt();
        int edge[][]=new int[m][3];
        for(int i=0;i<m;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
            edge[i][2]=sc.nextInt();
        }
        int ans=findMST(v,edge);
        System.out.println(ans);
    }
    public static int findMST(int v, int[][] edge){
        int[] parent=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=i;
        }
        Arrays.sort(edge,(x,y)->x[2]-y[2]);
        int cost=0, count=0;
        for(int[] e : edge){
            int x = e[0];
            int y = e[1];
            int w = e[2];
            if(find(parent, x) != find(parent, y)){
                union(parent, x, y);
                cost += w;
                count++;
                if(count == v-1) break;
            }
        }
        return cost;
    }
    public static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    public static void union(int[] parent, int i, int j) {
        int i1 = find(parent, i);
        int j1 = find(parent, j);
        parent[i1] = j1;
    }
}