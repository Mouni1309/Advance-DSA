// find the no of components of subgraph within the given disconnected undirected graph
import java.util.*;
public class p1{
    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int x : adj.get(node)) {
            if (!visited[x]) {
                dfs(adj, visited, x);
            }
        }
    }
    public static int getComponents(List<List<Integer>> adj, boolean[] visited) {
        int c = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                c++;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt(); 
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        while (true) {
            System.out.print("Enter -1 to stop adding edges or Enter an edge (u v): ");
            int u = sc.nextInt();
            if (u == -1) break;
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (Integer x : adj.get(i)) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        boolean[] visited = new boolean[n];
        int c= getComponents(adj, visited);
        System.out.println("Number of components: " + c);
    }

}