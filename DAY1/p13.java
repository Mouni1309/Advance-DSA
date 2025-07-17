// This Java program creates and displays an undirected graph using an adjacency list and then performs a recursive Depth-First Search (DFS) traversal starting from a user-specified vertex.
import java.util.*;
 class p13 {
    public static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i); 
    }
    public static void print(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (Integer x : adj.get(i)) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
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
        print(adj);
        System.out.println("Enter starting vertex for DFS:");
        int start = sc.nextInt();
        boolean[] visited = new boolean[n];
        dfs(start, visited, adj);
    }
    public static void dfs(int start, boolean[] visited, List<List<Integer>> adj) {
        visited[start] = true;
        System.out.print(start + " ");
        for (Integer x : adj.get(start)) {
            if (!visited[x]) {
                dfs(x, visited, adj);
            }
        }
    }
}
