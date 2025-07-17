// This code checks if one array is a permutation of another using a stack and queue.
// It reads two arrays from input, uses a queue to store elements of the first array, and a stack to store elements of the second array.
// The function checks if the elements of the second array can be obtained by popping elements from the stack in the same order as they appear in the second array.
// If the elements of the second array can be obtained by popping elements from the stack in the same order, it returns true; otherwise, it returns false.

import java.util.*;

class p2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[]=new int[m];
        int b[]=new int[n];
        for(int i=0;i<m;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
        System.out.println(permutation(a,b));
    }
    public static boolean permutation(int[] a, int[] b){
        if(a.length != b.length) return false;
        Queue<Integer> q = new LinkedList<>();
        for(int x : a) q.add(x);
        Stack<Integer> s = new Stack<>();
        int j = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            s.push(curr);
            while(!s.isEmpty() && s.peek() == b[j]) {
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
}