### Pattern Matching  - Pettern Searching
### String Matching  - String Searching
- pattern matching is also called as string matching or str searching or pattern searching it is a process of identifing a specific sequencs of chars or specific sequences of elements with in a large text. That means we are given a large text of data and also another small string which is called pattern . now we used to find the occurances of those small string with in lareg text of data . here occurance means the starting position of pattern string with in large text of data when we find . pattern matching not only finds single occurance it finds all the occurance of pattern string with in large text. the concept of pattern matching consists of 3 componets or 3 parts :-
    1. Pattern : it is a small string which is sequence of chars or symbols or both . in text processing applications it is simply string of chars 
    2. Text : It is a large text were we have collection several chars or symbols together . in pure text processing it is simply a large text string. Generally pattern and text both are inputs in the text the pattern is search for all its occurances 
    3. Match : Match means if a pattern is found in a text at specific point the goal of pattern matching is to find all the instances or occurance ofpattern on large text. In todays modern s/w world the concept ofpattern matching and algorithms to implete pattern matching are imp in developing s/w application like --  text mining or text processing , sentimental analysis(new concept in data analytics) bio-informatics , image processing , computer visoin application , and compiler design applications . Today text processing so imp along with ML and DL means text processing is a part of ML and DL. 
- example :
    - pattern : aba
    - text : abcababacabacababacab
    - match : 3,5,9,13,15
- To implement the above pattern match or pattern search we have diff algorithms 
1. brute force or naive algorithm
    - This algorithm works by comparing pattern starting with every possible  position in large etxt . that comparion can be done char by char one char at a time until there is a match found and all positions in the text are checked . let us assume that let N be the lenght of large text and M be the lenght of pattern text. because of this algorithm processor the effecive time complexity is o(m*n), this is because from every position in large text we are comparing pattern with large text one by one . this is a sliding window approch but in terms of pattern matching it is bruteforce
2. KMP( Knuth Morris Pratt) algorithm
    - KMP stands for Knuth Morris Pratt algorithm. This algorithm optimizes pattern searching process by avoiding unnesasary char comparision or repeated char comparisons. As a result the time complexity is O(n+m). This also a sliding window but it doesnot start with every char in main text. It starts with the first char of main text and whenever there is a mismatch or match then it uses a shift value to decide where to start next searching in main text this shift value avoids unnesary comparisions in the next searching process
    - now the entire algorithm based on shift value , 1st it computes shift value and implements pattern searching thus the procedure for kmp contains 2 parts :
        1. Cunstruction of LPS : is a pre processing that is done only once after that pattern search can be implemented in any no of times
            1. cunstruction of LPS table : here lps means longest proper prefix which is suffix. we know that a string contains several prefixes. a proper prefix means prefix which doesnot represents entire string. a prefix is always starting part of the string . a suffix always ending part of the string .
        2. The Pattern Search Process
    - steps
        1. in this preprocessing we compute lps values by using an array. the size of the array is same as size of the pattern that means in the given pattern for every proper prefix we compute lps values
        - code
        -------------
            void computeLPS(string pattern, int m, int lps[]{
                int len=0,i=1;
                lps[0]=0;
                while(i<m){
                    if(pattern.CharAt(i)==pattern.CharAt(len)){
                        len++;
                        lps[i]=len;
                        i++;
                    }
                    else if(len!=0)
                        len=lps[len-1];
                    else{
                        lps[i]=len;
                        i++;
                    }
                }
            }
        - code tracing - pattern = abab
            - if equals then len++ and lps[i]=len
            - else if len!=0 then len=lps[len-1]
            - i=1, len=0, pattern[1]=b, pattern[0]= a, lps[1]=0
            - i=2, len=0, pattern[2]=a, pattern[0]= a, lps[2]=1
            - i=3, len=1, pattern[3]=b, pattern[1]= b, lps[3]=2
            - lps[0 0 1 2]
        2. This is actually kmp algorithm
        - code
        ---------------------------
            void kmpSearch(String text, String pat){
                int m = pat.length();
                int n = text.length();
                int lps[] = new int[m];
                computeLPS(pat, m, lps);
                int i = 0, j = 0;
                while (i<n){
                    if (pat.CharAt(j) == text.CharAt(i)){
                        i++;
                        j++;
                    }
                    if (j == m){
                        System.out.println("Found at index " + (i - j));
                        j = lps[j - 1]; 
                    }
                    else if(i<n && pat.CharAt(j) != text.CharAt(i)){
                        if (j != 0) 
                            j = lps[j - 1];
                        else 
                            i++;
                    }
                }
            }
        - code tracing - text= abababab pattern=abab
            - i=0, j=0, text[0]=a, pattern[0]=a, lps[0]=0 - true i++, j++
            - i=1, j=1, text[1]=b, pattern[1]=b, lps[1]=0 - true i++, j++
            - i=2, j=2, text[2]=a, pattern[2]=a, lps[2]=1 - true i++, j++
            - i=3, j=3, text[3]=b, pattern[3]=b, lps[3]=2 - true i++, j++
            - j = 
            - print(i-j) - prints 1st occurance
            - i=4, j=lps[j-1]= lps[3]=2 , text[4]=a, pattern[2]=a - true i++, j++
            - i=5, j=3, text[5]=b, pattern[3]=b - true i++, j++
            - j =len(pattern);
            - print()

- Problems
    1. implement kmp algorithm for large text t with pattern p
        - i/p :
        - text = "aabaacaadaabaaba
        - pattern = "aaba"
        - o/p : 0 9 18
    2. plement kmpmsearch for large text for p no of patterns
3. boyer moore algorithm
4. Rabin Karp algorithm
5. ahocorisick algorithm


