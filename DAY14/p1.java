// This code finds all starting indices of anagrams of a string `p` in another string `s`.
// It uses a sliding window approach with character frequency counting to determine if the current window in ` s` is an anagram of `p`.
// The output is a list of starting indices where the anagrams occur.

import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String p=sc.nextLine();

        List<Integer> result=new ArrayList<>();
        if (s==null || p== null || s.length()<p.length()) {
            System.out.println(result);
            return;
        }
        int[] pc =new int[26];
        int[] wc =new int[26];
        for (int i=0;i<p.length();i++) {
            pc[p.charAt(i)-'a']++;
            wc[s.charAt(i)-'a']++;
        }
        boolean isMatch = true;
        for (int i=0;i<26;i++) {
            if (pc[i]!=wc[i]) {
                isMatch=false;
                break;
            }
        }
        if (isMatch) {
            result.add(0);
        }
        for (int i=p.length();i<s.length();i++) {
            wc[s.charAt(i-p.length())-'a']--;
            wc[s.charAt(i)-'a']++;
            isMatch = true;
            for (int j=0;j<26;j++) {
                if (pc[j]!=wc[j]) {
                    isMatch=false;
                    break;
                }
            }
            if (isMatch) {
                result.add(i-p.length()+1);
            }
        }
        System.out.println(result);
    }
}


// import java.util.*;
// class p1{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String s=sc.next();
//         String p=sc.next();
//         int[] res=findAnagram(s,p);
//         for(int i=0;i<res.length;i++)
//         System.out.println(res[i]);
//     }
//     public static int[] findAnagram(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         int[] res = new int[n - m + 1];
//         for (int i = 0; i <=n;i++){
//             if(i+m<=n){
//                 String s1 = s.substring(i, i + m);
//                 String s2 = p;
//                 if (s1.equals(s2)) {
//                     res[i] = i;
//                 }
//             }
//         }
//         return res;
//     }
// }