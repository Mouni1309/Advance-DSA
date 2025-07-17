// find and written the no of components of subgraph within the given disconnected undirected graph
import java.util.*;
public class p2{
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
    public static List<List<Integer>> getComponents(List<List<Integer>> adj, boolean[] visited) {
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(adj, visited, i);
                for (int j = 0; j < visited.length; j++) {
                    if (visited[j]) {
                        component.add(j);
                        visited[j] = false;
                    }
                }
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
        List<List<Integer>> res = getComponents(adj, visited);
        System.out.println("Components:");
        for (List<Integer> res1 : res) {
            System.out.println(res1);
        }
    }

}