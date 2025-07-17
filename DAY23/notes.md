### Rabin-karp algorithm
- Rbin karp algorithm is another efficient string searching algorithm which uses a concept called hasing or hash function to find all occurances of given pattern with in a large text . the main idea is developing algorithm with the following components
    1. hashing  : hashing is a concept that convert pattern into numerical hash value by using hash function. this hash value for pattern is same throutout the program. it also computes nmerical hash value for diff substrings of main text. inorder to convert a pattern into numerical hash value or substring of text into numerical value it uses following elements and formula.
        - d : alphabet size
        - q : prime number (larger than alphabet size or same digit length as alphabet size)
        - m : length or size of pattern 
        - hash value of pattern : initially p=0 and p=(d*p+c)%q
        - t=0 and t=(d*t+c)%q
        - h=(d ** m-1)%q
    2. Comparision : instead of comparing chars in pattern and text it compares hash values of pattern and substring of the text. if hash value are equal than it compares chars one by one , otherwise it ignore 1st substring finds 2nd substring using sliding window even if hash values are value , all chars equal means pattern is found then also find next substring usinf sliding window.
    3. Rolling hash : now from 2nd substring onwards for every substring it uses rolling hash to update hash value. rolling hash doesnot calculate hash value from scratch instead from existing hash value it subtracts 1st char and adds hash value of the next char for that it uses h value
- code
--------------
    void SearchRabinKarp(String text, String p, int d, int q){
        int m = p.length();
        int n = text.length();
        int h=1, p=0, t=0;
        for(int i=0;i<m;i++){
            h=(d*h)%q;
        }
        for(int i=0;i<m;i++){
            p=(d*p+(int)p.charAt(i))%q;
            t=(d*t+(int)text.charAt(i))%q;
        }
        for(int i=0;i<= n-m;i++){
            if(p==t){
                for(int j=0;j<m;j++){
                    if(text.charAt(i+j)!=p.charAt(j))
                        break;
                }
                if(j==m)
                    System.out.println("Pattern found at index "+i);
            }
            if(i<n-m){
                t=(d*(t-(int)text.chatAt(i)*h+text.charAt(i+m)))%q;
                if(t<0)
                t=t+q;
            }
        }
    } 
- todo
    1. develop a program to print all occurances of pattern p in text t using rabin karp algorithm
- code
----------
    class Solution {
        public static void main(String[] args) {
            Scaner sc=new Scanner(System.in);
            String s=sc.nextLine();
            List<String> res=find(s);
            for(String x:res)
                System.out.println(x);
        }
        List<String> find(String s){
            List<String> res=new ArrayList<>();
            StringBuilder sb=new StringBuilder(s);
            find1(0,sb,res);
            collections.sort(res);
            return res;
        }
        void find1(int ind,StringBuilder s, List<String>res){
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
        void swap(StringBuilder s,int i,int j){
            char t= s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,t);
        }
    }
#### problems on baccktracking
1. we are given a string s find and return all permutations of string s
- example : input string s = "abc" output = ["abc","acb","bac","bca","cab","cba"]
2. Find all permutations of given string s find and return all permutations of string s
3. find all permutations of given numeric array of size n using BST
4. 2nd with sorted order array
5. 3rd with sorted order array
6. find all permutations of given string without duplicates

#### interview questions
1. 
2. What is relation b/w XML and DataBase?
3. What is DeNormalization?
4. What is Intension(schema or metadata) and Extension(actual data) in DataBase?
5. NoSQL DB : MongoDB,Apache Cassandra,Redis,Neo4j,Amazon DynamoDB,Apache HBASE, Rias, CouchDB, OrientDB, Cosmos DB, XML