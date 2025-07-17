// This Java program implements a Disjoint Set Union (DSU) or Union-Find data structure to track the sizes of connected components as you unite pairs of elements. After each union operation, it prints the difference between the largest and smallest component sizes.
import java.util.*;
class p8{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] parent = new int[n + 1];
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            s[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(parent, s, x, y);
            Set<Integer> res=new HashSet<>();
            List<Integer> sizes = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                int root = find(parent, j);
                if (!res.contains(root)) {
                    res.add(root);
                    sizes.add(s[root]);
                }
            }
            int min=Collections.min(sizes);
            int max=Collections.max(sizes);
            System.out.println("diff:"+(max-min));
        }

    }
    public static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    public static void union(int[] parent, int[] s, int x, int y) {
        int x1 = find(parent, x);
        int y1 = find(parent, y);
        if (x1 != y1) {
            if (s[x1] < s[y1]) {
                parent[x1] = y1;
                s[y1] += s[x1];
            } else {
                parent[y1] = x1;
                s[x1] += s[y1];
            }
        }
    }
}