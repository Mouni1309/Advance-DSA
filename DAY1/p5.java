// program to creates and displays an undirected graph using an adjacency list implemented with a HashMap.
import java.util.*;
 class p5 {
    public static void addEdge(HashMap<Integer,List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i); 
    }
    public static void print(HashMap<Integer,List<Integer>> adj) {
        for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
            System.out.print(e.getKey() + ": ");
            for (Integer x : e.getValue()) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
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
