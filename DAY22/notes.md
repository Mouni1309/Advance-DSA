### Boyer-Moore Algorithm
- we know kmp algorithm is efficiant algorithm for pattern searching to search all occurances of given pattern in a large text. we have another efficient algorithm for the same purpose called Boyer-Moore algorithm. this algorithm is based on 2 imp rules 
    1. bad character heuristic rule
    2. good suffix heuristic rule
- based on this 2 rules we have 3 diff versions of (types of ) Boyer-Moore algorithm. 
    1. Boyer-Moore Algorithm using bad character heuristic rule
    2. Boyer-Moore Algorithm using good suffix heuristic rule
    3. Boyer-Moore Algorithm using combined bad character and good suffix heuristic rule
1. Boyer-Moore Algorithm using bad character heuristic rule
    - This version of boyer moore algorithm 1st computes a bad character table(array). and from this table it finds shift value whenever there is mismatch when we compare pattern with text. similarly if pattern is found also it uses same bad character table to finds shift value. here bad character means when we comparing pattern with text the charactre in text that doesnot match with corresponding texrt with pattern is called bad character. During pattern matching once there is mismatch we identify bad character and to find shift value there 2 cases :
        1. if the bad character appears in some other position in pattern 
        2. if the bad character doesnot exist in pattern 
    - based on these 2 cases shift value is identified. the construction bad character table is done on pattern only and it is nothing but storing 1st occurance of character in pattern as a value for character as a key. The following example explains how to cunstructs bad character table. one imp point is both construction or bad table and pattern seasrching can be done in right to left.
    - Example: 
        - text : abaaaabaacd
        - pattern : aba
        - bc table : a : 0, b : 1
        - i=0,j=len(pattern)
        - i=0,j=3
        - now we start from right to left. we compare pattern with text. at first position there is no mismatch
        - so return its index
        - if incase any mismatch we check is there any bad character in pattern. if yes then we find its 1st occurance in pattern and shift
        - if no then we shift by len(pattern)
        - Example:
        - i=0,j=3
        - i=0,j=2
        - i=0,j=1
        - i=0,j=0
        - now we check again by shift the pattern length in the main text
        - i=4,j=3
        - i=4,j=2 - false
        - so it checks whether the bad character is present in the pattern or not
        - if yes then it shifts by 1st occurance of bad character in pattern
        - if no then it shifts by len(pattern)
        - now i=4 , j=3 - false
        - so again checks whethet it present in pattern 
        - if yes then it shifts by 1st occurance of bad character in pattern
        - later it matches and prints its posistion
        - Time complexity of Boyer-Moore Algorithm using bad character heuristic rule is O(n/m) where n is length of text and m is length of pattern. Space complexity is O(m) for bad character table.

    - code 
    -------------   
        import java.util.*;
        public class p1{
            public static void main(String[] args) {
                Scanner sc=new Scanner (System.in);
                String text=sc.next();
                String p=sc.next();
                BoyerMoore(text, p);
            }
            public static void BoyerMoore(String text, String p){
            int m = p.length();
            int n = text.length();
            int bc[] = new int[256];
            BadCharacterHeuristic(p,m,bc);
            int i=0;
            while(i<=(n-m)){
                int j=m-1;
                while(j>=0 && p.charAt(j) == text.charAt(i+j)){
                    j--;
                }
                if(j<0){
                    System.out.println("Pattern found at index "+i);
                    if(i<n-m)
                        i=i+m-bc[(int)text.charAt(i+m)];
                    else
                        i=i+1;
                }
                else{
                    i=i+m-j-bc[(int)text.charAt(i+j)];
                }
            }
        }
        public static void BadCharacterHeuristic(String p,int m, int bc[]){
            for(int i=0;i<256;i++)
                bc[i]=-1;
            for(int i=m-1;i>=0;i--)
                bc[(int)p.charAt(i)]=i;
        }
        }
2. Boyer-Moore Algorithm using good suffix heuristic rule
    - code 
    ------------------------
        void BoyerMoore(String text, String p){
            int m = p.length();
            int n = text.length();
            int bpos[] = new int[m+1];
            int shift[]=new int[m+1];
            for(int i=0;i<=m;i++)
                shift[i]=0;
            strong_suffix1(shift,bpos,p,m);
            strong_suffix2(shift,bpos,p,m);
            int i=0,j;
            while(i<=(n-m)){
                j=m-1;
                while(j>=0 && p.charAt(j)==text.charAt(i+j))
                    j--;
                if(j<0){
                    System.out.println("Pattern found at index "+i);
                    i = i +shift[0];
                }
                else
                    i = i +shift[j + 1];
            }
        }
        void strong_suffix1(int shift[],int bpos[],String p,int m){
            int i=m,j=m+1;
            bpos[i]=j;
            while(i>0){
                while(j<=m && p.charAt(i-1)!=p.charAt(j-1)){
                    if(shift[j]==0)
                        shift[j]=j-1;
                    j=bpos[j];
                }
                i--;
                j--;
                bpos[i]=j;
            }
        }
        void strong_suffix2(int shift[],int bpos[],String p,int m){
            int i,j;
            j=bpos[0];
            for(int i=0;i<=m;i++){
                if(shift[i]==0)
                    shift[i]=j;
                if(i==j)
                    j=bpos[j];
            }
        }

#### list of programs
1. boyer pattern matching using bad character
2. boyer pattern matching using strong suffix rule
3. boyer moree pattern matching using both bad char and strong suffix rules