// implementation of disjoint sets to find 2 elements are belongs to same set or not
import java.util.*;

public class p5 {
    public static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }
    public static void union(int[] parent, int i, int j) {
        int i1 = find(parent, i);
        int j1 = find(parent, j);
        parent[i1] = j1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        System.out.print("Enter number of unions: ");
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(parent, x, y);
        }
        System.out.print("Enter number of queries: ");
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            int s = sc.nextInt();
            int s1 = sc.nextInt();
            if (find(parent, s) == find(parent, s1)) {
                System.out.println("Same set");
            } else {
                System.out.println("Different set");
            }
        }
    }
}
