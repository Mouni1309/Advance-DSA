// program to creates and displays an undirected graph using an adjacency matrix and then performs an iterative Depth-First Search (DFS) traversal starting from a user-specified vertex.
import java.util.*;
 class p8 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt(); 
        int m[][] = new int[n][n];
        while (true) {
            System.out.print("Enter -1 to stop adding edges or Enter an edge (u v): ");
            int u = sc.nextInt();
            if (u == -1) break;
            int v = sc.nextInt();
            addEdge(m, u, v);
        }
        System.out.println("\nAdjacency Matrix:");
        print(m);
        System.out.println("Enter starting vector:");
        int start = sc.nextInt();
        boolean[] visited = new boolean[n];
        dfs(start, visited, m);
    }
    public static void dfs(int start, boolean[] visited, int[][] m) {
        Stack<Integer> st = new Stack<>();
        visited[start] = true;
        st.push(start);
        while (!st.isEmpty()) {
            int curr= st.pop();
            System.out.print(curr + " ");
            for (int i = 0; i < m[curr].length; i++) {
                if (m[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
    }
}
