// interleaves the first and second halves of a queue using a stack.
import java.util.*;
public class p1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
            q.add(sc.nextInt());
        Stack<Integer> s = new Stack<>();
        int half = n / 2;
        for(int i = 0; i < half; i++)
            s.push(q.remove());
        while(!s.isEmpty())
            q.add(s.pop());
        for(int i = 0; i < half; i++)
            q.add(q.remove());
        for(int i = 0; i < half; i++)
            s.push(q.remove());
        while(!s.isEmpty()){
            q.add(s.pop());
            q.add(q.remove());
        }
        while(!q.isEmpty())
            System.out.print(q.remove() + " ");
    }
}