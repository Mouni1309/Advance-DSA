// connecting employees from new companies using DSU
import java.util.*;
class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        int[] parent = new int[n + 1];
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            s[i] = 1;
        }
        for (int i = 0; i < q; i++) {
            String ch[] = sc.nextLine().split(" ");
            if (ch[0].equalsIgnoreCase("q") && ch.length >= 2) {
                int ans = getTotal(parent, s, Integer.parseInt(ch[1]));
                System.out.println(ans);
            } else if (ch[0].equalsIgnoreCase("c") && ch.length >= 3) {
                int a = Integer.parseInt(ch[1]);
                int b = Integer.parseInt(ch[2]);
                union(parent, s, a, b);
            }
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
    public static int getTotal(int[] parent, int[] s, int x) {
        return s[find(parent, x)];
    }
}
