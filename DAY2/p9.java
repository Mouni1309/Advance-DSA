// no of islands in a 2D grid using DFS
import java.util.*;
public class p9 {
    public static void dfs(int i, int j, int m, int n, char[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        dfs(i + 1, j, m, n, grid);
        dfs(i - 1, j, m, n, grid);
        dfs(i, j + 1, m, n, grid);
        dfs(i, j - 1, m, n, grid);
    }
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, m, n, grid);
                    c++;
                }
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the grid dimensions (rows and columns):");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[rows][cols];
        System.out.println("Enter the grid (use '1' for land and '0' for water):");
        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        int islands = numIslands(grid);
        System.out.println("Number of islands: " + islands);
    }
}