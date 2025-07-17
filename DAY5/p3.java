// detect a cycle in a graph using dfs
import java.util.*;
class p3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int m=sc.nextInt();
        int edge[][]=new int[m][2];
        for(int i=0;i<m;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
        }
        boolean ans = isCycle(v, adj);
        System.out.println(ans);
    }
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i] && dfs(adj,i, visited, recStack)) {
                    return true;
            }
        }     
        return false;  
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recStack) {
        if(recStack[s]==true) return true;
        if(visited[s]== true) return false; 
        visited[s]=true;
        recStack[s]=true;
        for(int x:adj.get(s)){
            if(dfs(adj,x,visited,recStack)) return true;
        }
        recStack[s]=false;
        return false;
    }    
}