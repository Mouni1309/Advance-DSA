// builds a Binary Search Tree (BST) from user input and provides methods to print:

// The left boundary of the tree
// The right boundary of the tree
// All leaf nodes
import java.util.*;
class p1 {
    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
    static void printLeftBoundary(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            if (curr.left != null)
                curr = curr.left;
            else if (curr.right != null)
                curr = curr.right;
            else
                break;
        }
    }
    static void printRightBoundary(Node root) {
        Node curr = root;
        while(curr != null) {
            System.out.print(curr.val + " ");
            if (curr.right != null)
            curr = curr.right;
            else if (curr.left != null)
            curr = curr.left;
            else
            break;
        }
    }
    static void printLeaves(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) System.out.print(root.val + " ");
        printLeaves(root.left);
        printLeaves(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }
        printLeftBoundary(root);
        System.out.println();
        printRightBoundary(root);
        System.out.println();
        printLeaves(root);

        printLeftBoundary(root);
        printLeaves(root);
        printRightBoundary(root);

    }
}