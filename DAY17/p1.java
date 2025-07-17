// finds all 10-letter-long sequences (substrings) that occur more than once in a given string.

import java.util.*;

class p1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> res = find(s);
        for (int i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
    }

    public static ArrayList<String> find(String s) {
       Set<String> ans = new HashSet<>();
    Set<String> seen = new HashSet<>();
    for (int i = 0; i + 10 <= s.length(); i++) {
      final String seq = s.substring(i, i + 10);
      if (seen.contains(seq))
        ans.add(seq);
      seen.add(seq);
    }
    return new ArrayList<>(ans);
    }
}