// find the no of components of subgraph using bfs and adj list within the given disconnected undirected graph
import java.util.*;
public class p5 {
    public static void bfs(List<List<Integer>> adj, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public static int getComponents(List<List<Integer>> adj, boolean[] visited) {
        int count = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                bfs(adj, visited, i);
                count++;
            }
        }
        return count;
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
            adj.get(u).add(v);
            adj.get(v).add(u);
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
        int components = getComponents(adj, visited);
        System.out.println("Number of components: " + components);
    }

}