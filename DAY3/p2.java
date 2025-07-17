// Problem: Count Paths in a Directed Acyclic Graph using BFS
import java.util.*;
public class p2{
    public static int countPaths(int v, int[][] edges, int src, int dest){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
        }
        int ans=bfs(src,dest,adj);
        return ans;
    }
    public static int bfs(int src, int dest, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        int count=0;
        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                int node=q.poll();
                if(node==dest) count++;
                for(int x:adj.get(node)){
                    q.add(x);
                }
            }
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