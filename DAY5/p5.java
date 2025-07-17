// Topological sort using dfs
import java.util.*;
class p5 {
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
        for (int i = 0; i < m; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
        }
        List<Integer> ans = topologicalSort(v, adj);
        System.out.println(ans);
    }

    public static List<Integer> topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;
        
        for (int x : adj.get(s)) {
            if (!visited[x]) {
                dfs(adj, x, visited, stack);
            }
        }
        
        stack.push(s);
    }
}