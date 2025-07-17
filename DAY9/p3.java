// word pattern
import java.util.*;
class p3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String str = sc.nextLine();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            System.out.println("false");
            return;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if (!map.containsKey(ch)) {
                if (usedWords.contains(word)) {
                    System.out.println("false");
                    return;
                }
                map.put(ch, word);
                usedWords.add(word);
            } else {
                if (!map.get(ch).equals(word)) {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }
}