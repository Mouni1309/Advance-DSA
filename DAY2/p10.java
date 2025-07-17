// check if all the nodes of undirected graph can be visited from a given node using DFS.
import java.util.*;
public class p10 {
    public static void dfs(int[][] adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }

    public static boolean canVisit(int[][] adj, int start) {
        boolean[] visited = new boolean[adj.length];
        dfs(adj, visited, start);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
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
        System.out.print("Enter starting node: ");
        int start = sc.nextInt();
        boolean result = canVisit(adj, start);
        System.out.println("Can visit all nodes from node " + start + ": " + result);
    }
}