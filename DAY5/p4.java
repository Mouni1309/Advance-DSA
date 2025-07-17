// detect a cycle in a graph using bfs
import java.util.*;
class p4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int m = sc.nextInt();
        int edge[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[v];
        for (int i = 0; i < m; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
            inDegree[edge[i][1]]++;
        }
        boolean ans = isCycle(v, adj, inDegree);
        System.out.println(ans);
    }

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return count != v;
    }    
}