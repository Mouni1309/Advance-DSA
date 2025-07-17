// This code finds the number of unique paths from a source cell to a destination cell in a grid, where you can only move to adjacent cells with lower values.
// It uses a depth-first search (DFS) approach with memoization to avoid recalculating paths for already visited cells.
// The input consists of the dimensions of the grid and the values in each cell, along with the source and destination coordinates.

import java.util.*;
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int srcRow = sc.nextInt();
        int srcCol = sc.nextInt();
        int destRow = sc.nextInt();
        int destCol = sc.nextInt();
        int res = findPossible(m, n, arr, srcRow, srcCol, destRow, destCol);
        System.out.println(res);
    }
    static int findPossible(int m, int n, int[][] arr, int srcRow, int srcCol, int destRow, int destCol) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        boolean[][] visited = new boolean[m][n];
        return callDFS(m, n, arr, srcRow, srcCol, destRow, destCol, dp, visited);
    }
    static int callDFS(int m, int n, int[][] arr, int row, int col, int destRow, int destCol, int[][] dp, boolean[][] visited) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        if (row == destRow && col == destCol) {
            return 1;
        }
        visited[row][col] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
        int paths = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                arr[newRow][newCol] < arr[row][col] && !visited[newRow][newCol]) {
                paths += callDFS(m, n, arr, newRow, newCol, destRow, destCol, dp, visited);
            }
        }
        visited[row][col] = false;
        dp[row][col] = paths; 
        return paths;
    }
}