// implements a Wordsearch class that checks if a given word can be found in a 2D board of characters, following the rules of the classic "Word Search" puzzle.
import java.util.*;

public class Wordsearch {
    private char[][] board;
    private String word;

    public Wordsearch(char[][] board, String word) {
        this.board = board;
        this.word = word;
    }

    public boolean exist() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(i + 1, j, k + 1) || dfs(i - 1, j, k + 1) || dfs(i, j + 1, k + 1) || dfs(i, j - 1, k + 1);
        board[i][j] = temp;
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();

        char[][] board = new char[rows][cols];
        System.out.println("Enter the characters for the board:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }

        System.out.println("Enter the word to search:");
        String word = scanner.next();

        Wordsearch wordSearch = new Wordsearch(board, word);
        System.out.println("Word found: " + wordSearch.exist());
    }
}