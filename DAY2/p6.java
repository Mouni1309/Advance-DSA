// find and written the no of components of subgraph using bfs and adj list within the given disconnected undirected graph
import java.util.*;
public class p6 {
    public static void bfs(List<List<Integer>> adj, boolean[] visited, int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        component.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    component.add(neighbor);
                }
            }
        }
    }
    public static List<List<Integer>> getComponents(List<List<Integer>> adj, boolean[] visited) {
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                bfs(adj, visited, i, component);
                components.add(component);
            }
        }
        return components;
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
        List<List<Integer>> components = getComponents(adj, visited);
        System.out.println("Components:");
        for (List<Integer> component : components) {
            System.out.println(component);
        }
    }
}
