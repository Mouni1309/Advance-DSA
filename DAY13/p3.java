// count no of sub strings of lenght k and with x no of vowels
import java.util.Scanner;

public class p3 {
    public static boolean noofVowels(String s, int start, int end,int x) {
        int c=0;
        for(char ch:s.substring(start,end).toCharArray())
        {
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                c++; 
            }
        }
        return c == x;
    }
    public static int countSubstrings(String s, int k, int x) {
        int max = 0;
        int n= s.length();
        for (int i = 0; i <= n - k; i++) {
            boolean ans = noofVowels(s, i, i + k,x);
            if(ans)
            {
                max++;
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s=sc.nextLine();
        int k = sc.nextInt();
        int x=sc.nextInt();
        
        int ans = countSubstrings(s, k, x);
        System.out.println(ans);
    }
    
}