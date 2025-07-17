// Find all permutations of given string s find and return all permutations of string s
import java.util.*;
class p2 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            List<String> res=find(s);
            for(String x:res)
                System.out.println(x);
        }
        public static List<String> find(String s){
            List<String> res=new ArrayList<>();
            StringBuilder sb=new StringBuilder(s);
            find1(0,sb,res);
            Collections.sort(res);
            return res;
        }
        public static void find1(int ind,StringBuilder s, List<String>res){
            if(ind==s.length()){
                res.add(s.toString());
                return;
            }
            for(int i=ind; i<s.length();i++){
                swap(s,ind,i);
                find1(ind+1,s,res);
                swap(s,ind,i);
            }
        }
        public static void swap(StringBuilder s,int i,int j){
            char t= s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,t);
        }
}