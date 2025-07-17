// detect a cycle in a graph using dsu
import java.util.*;
class p2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int m=sc.nextInt();
        int edge[][]=new int[m][2];
        for(int i=0;i<m;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }
        boolean ans=isCycle(v, edge);
        System.out.println(ans);
    }
    public static boolean isCycle(int v, int [][]edge){
        int[] parent=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=i;
        }
        for (int[] e : edge) {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);
            if (x == y)
                return true;
            union(parent, x, y);
        }
        return false;
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