// finds the longest common prefix among a set of input strings.
import java.util.Arrays;
import java.util.Scanner;

class p4 {
    public static String LongPrefix(String s[]){
        Arrays.sort(s);
        String s1="";
        for(int i=0;i<s[0].length() && i<s[s.length-1].length();i++)
        if(s[0].charAt(i)==s[s.length-1].charAt(i)){
            s1=s1+s[0].charAt(i);
        }
        return s1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.next();
        }
        System.out.println(LongPrefix(arr));

    }
}
