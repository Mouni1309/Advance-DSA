import java.util.*;
class p5{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(SCS(s1,s2));
    }
    public static int SCS(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(s1.charAt(i)==s2.charAt(j))
                    c++;
            }
        }

        int res=m+n-c;
        return res;
    }
}