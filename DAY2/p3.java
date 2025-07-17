// find the no of components using DFS and adj matrix within the given disconnected undirected graph
import java.util.*;
public class p3 {
    public static void dfs(int[][] adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }
    public static int getComponents(int[][] adj, boolean[] visited) {
        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] adj = new int[n][n];
        while (true) {
            System.out.print("Enter -1 to stop adding edges or Enter an edge (u v): ");
            int u = sc.nextInt();
            if (u == -1) break;
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        boolean[] visited = new boolean[n];
        int components = getComponents(adj, visited);
        System.out.println("Number of components: " + components);
    }

}