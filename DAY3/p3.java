// Biparite graph check using DFS
import java.util.*;
public class p3 {
    public static boolean isBipartite(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int[] color = new int[v];
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (!dfs(adj, color, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int node, int col) {
        color[node] = col;
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) {
                if (!dfs(adj, color, neighbor, 1 - col)) {
                    return false;
                }
            } else if (color[neighbor] == col) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int n = sc.nextInt();
        int[][] edges = new int[n][2];
        System.out.println("Enter edges:");
        for (int i = 0; i < n; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        
        boolean result = isBipartite(v, edges);
        System.out.println(result);
    }
}