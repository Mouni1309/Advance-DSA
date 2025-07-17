// find and written components using dfs and adj matrix within the given disconnected undirected graph
import java.util.*;
public class p4 {
    public static void dfs(int[][] adj, boolean[] visited, int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(adj, visited, i, component);
            }
        }
    }

    public static List<List<Integer>> getComponents(int[][] adj, boolean[] visited) {
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(adj, visited, i, component);
                components.add(component);
            }
        }
        return components;
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
        List<List<Integer>> components = getComponents(adj, visited);
        System.out.println("Components:");
        for (List<Integer> component : components) {
            System.out.println(component);
        }
    }
}