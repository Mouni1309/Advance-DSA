// program creates and displays an undirected graph using an adjacency matrix and then performs a Breadth-First Search (BFS) traversal starting from a user-specified vertex.
import java.util.*;
public class p12 {
        public static void addEdge(int[][] m, int i, int j) {
            m[i][j] = 1;
            m[j][i] = 1; 
        }
        public static void print(int[][] m) {
            for (int i = 0; i < m.length; i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < m[i].length; j++) {
                    if (m[i][j] == 1) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }
        }
        public static void bfs(int[][] m, int start) {
            boolean[] visited = new boolean[m.length];
            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.add(start);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");
                for (int i = 0; i < m[node].length; i++) {
                    if (m[node][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of vertices: ");
            int n = sc.nextInt();
            int[][] m = new int[n][n];
            while (true) {
                System.out.print("Enter -1 to stop adding edges or Enter an edge (u v): ");
                int u = sc.nextInt();
                if (u == -1) break;
                int v = sc.nextInt();
                addEdge(m, u, v);
            }
            System.out.println("\nAdjacency Matrix:");
            print(m);
            System.out.print("Enter starting node for BFS: ");
            int start = sc.nextInt();
            System.out.println("BFS Traversal:");
            bfs(m, start);
        }
}
