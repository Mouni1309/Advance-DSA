// program to creates and displays a directed graph using an adjacency list.
import java.util.*;
 class p4 {
    public static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
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
        print(adj);
    }
}
