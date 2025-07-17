// check if all the nodes of undirected graph can be visited from a given node using DFS and adj list
// input: N=5   [[1,2],[0,3,2],[0,1],[1]]
// output: true
import java.util.*;
public class p11 {
    public static void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }
    public static boolean canVisit(List<List<Integer>> adj, int start) {
        boolean[] visited = new boolean[adj.size()];
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
        System.out.print("Enter starting node: ");
        int start = sc.nextInt();
        boolean result = canVisit(adj, start);
        System.out.println("Can visit all nodes from node " + start + ": " + result);
    }
}