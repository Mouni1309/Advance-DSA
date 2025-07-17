// Problem: Count Paths in a Directed Acyclic Graph using DFS
import java.util.*;
public class p1{
    public static int countPaths(int v, int[][] edges, int src, int dest){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
        }
        int ans=dfs(src,dest,adj);
        return ans;
    }
    public static int dfs(int src, int dest, ArrayList<ArrayList<Integer>> adj){
        if(src==dest) return 1;
        int count=0;
        for(int x:adj.get(src)){
            count+=dfs(x,dest,adj);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.err.println("enter no of vertices:");
        int v=sc.nextInt();
        System.err.println("enter no of edges:");   
        int n=sc.nextInt();
        int[][] edges=new int[n][2];
        System.err.println("enter edges:");
        for(int i=0;i<n;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        System.err.println("enter source and destination:");
        int src=sc.nextInt();
        int dest=sc.nextInt();
        int res=countPaths(v,edges,src,dest);
        System.out.println("no of paths:"+res);
    }
}