// This Java program creates and displays an undirected graph using an adjacency list and then finds and prints all connected components using Breadth-First Search (BFS).
import java.util.*;
public class p14 {
    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void bfs(int start, boolean[] visited, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for (Integer neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
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
        System.out.println("Enter edges (u v) or -1 to stop:");
        while (true) {
            int u = sc.nextInt();
            if (u == -1) break;
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }
        System.out.println("\nAdjacency List:");
        for (int i = 0; i
    < adj.size(); i++) {
                System.out.print(i + ": ");
                for (Integer x : adj.get(i)) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("BFS starting from node " + i + ":");
                bfs(i, visited, adj);
                System.out.println();
            }
        }
    }
}