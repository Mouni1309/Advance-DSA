// This code finds the maximum length of a contiguous subarray with an equal number of 0s and 1s.
// It uses a HashMap to track the cumulative sum of the elements, treating 0s as -1 and 1s as 1.
// The maximum length is calculated by checking the difference between indices where the same cumulative sum occurs.
// The algorithm runs in O(n) time complexity.
// The input is an array of integers consisting of 0s and 1s.
// The output is the maximum length of a contiguous subarray with an equal number of 0s and 1s.
// Example input: [0, 1, 0, 1, 1, 0]
// Example output: 6 (the entire array has an equal number of 0s and 1s)
import java.util.*;
class p2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(maxLen(a));
    }
    public static int maxLen(int arr[]){
        HashMap<Integer, Integer> hp = new HashMap<>();
        int sum = 0;
        int max = 0;
        
        hp.put(0, -1);
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==0) {
                sum += -1;
            } else {
                sum += 1;
            }
            
            if(hp.containsKey(sum)) {
                max = Math.max(max, i - hp.get(sum));
            } else {
                hp.put(sum, i);
            }
        }
        
        return max;
    }
}