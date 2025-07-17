// This code implements a segment tree to efficiently handle range minimum queries and point updates.
// It builds a segment tree from an array, allows querying the minimum value in a range, and updating values at specific positions.
// The segment tree is built using a recursive approach, and the query and update operations are performed using iterative methods.
// The input consists of an array of integers and a series of queries for minimum values in specified ranges, as well as updates to specific indices.
// The output is the minimum value for each query and the updated array after performing updates.
// Time complexity: O(n log n) for building the segment tree, O(log n) for each query and update operation.

import java.util.*;
class p4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int tree[]=new int[2*n];
        build(tree,n,a);
        int m=sc.nextInt();
        while(m-->0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            System.out.println(query(tree, n, l, r));
        }
        update(tree, a, n, 2, 5);
        query(tree, n, 1, 5);
    }
    public static void build(int[] tree, int n, int[] a) {
        for(int i=0; i<n; i++) {
            tree[n+i] = a[i];
        }
        for(int i=n-1; i>0; i--) {
            tree[i] = Math.min(tree[2*i], tree[2*i+1]);
        }
    }
    public static int query(int[] tree, int n, int l, int r) {
        l += n;
        r += n;
        int min = Integer.MAX_VALUE;
        while(l < r) {
            if((l & 1) == 1) {
                min = Math.min(min, tree[l]);
                l++;
            }
            if((r & 1) == 1) {
                r--;
                min = Math.min(min, tree[r]);
            }
            l /= 2;
            r /= 2;
        }
        return min;
    }
    public static void update(int[] tree, int a[],int n, int pos, int value) {
        pos += n;
        tree[pos] = value;
        a[pos-n] = value;
        while(pos > 1) {
            pos /= 2;
            tree[pos] = Math.min(tree[2*pos], tree[2*pos+1]);
        }
    }
}