// find all permutations of given numeric array of size n using BST
import java.util.*;

class BSTNode {
    String val;
    BSTNode left, right;
    BSTNode(String val) {
        this.val = val;
        left = right = null;
    }
}
class BST {
    BSTNode root;

    void insert(String val) {
        root = insertRec(root, val);
    }
    private BSTNode insertRec(BSTNode root, String val) {
        if (root == null) return new BSTNode(val);
        int cmp = val.compareTo(root.val);
        if (cmp < 0) root.left = insertRec(root.left, val);
        else if (cmp > 0) root.right = insertRec(root.right, val);
        return root;
    }

    void inorder(BSTNode node, List<String> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}

public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        BST bst = new BST();
        permute(arr, 0, bst);

        List<String> res = new ArrayList<>();
        bst.inorder(bst.root, res);
        for(String s : res) System.out.println(s);
    }

    static void permute(int[] arr, int l, BST bst) {
        if (l == arr.length) {
            StringBuilder sb = new StringBuilder();
            for(int num : arr) sb.append(num).append(" ");
            bst.insert(sb.toString().trim());
            return;
        }
        for(int i = l; i < arr.length; i++) {
            swap(arr, l, i);
            permute(arr, l+1, bst);
            swap(arr, l, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}