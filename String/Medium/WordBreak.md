[Problem](https://practice.geeksforgeeks.org/problems/word-break1352/1)

#### Method-1: Trie Solution

```java
class Sol
{
    static final int ALPHABET_SIZE = 26;
    
    static class Trie{
        Trie[] children;
        boolean isEndOfWord;
        
        Trie(){
            children = new Trie[ALPHABET_SIZE];
            for(int i=0;i<ALPHABET_SIZE;i++)
                children[i]=null;
            isEndOfWord = false;
        }
    }
    
    static void insert(Trie root, String key){
        Trie tmp = root;
        int child;
        for(int i=0;i<key.length();i++){
            child = key.charAt(i)-'a';
            if(tmp.children[child]==null){
                tmp.children[child] = new Trie();
            }
            tmp = tmp.children[child];
        }
        tmp.isEndOfWord = true;
    }
    
    static boolean search(Trie root, String key){
        Trie tmp=root;
        int child;
        for(int i=0;i<key.length();i++){
            child = key.charAt(i)-'a';
            if(tmp.children[child]==null)
                return false;
            tmp = tmp.children[child];
        }
        if(tmp!=null && tmp.isEndOfWord)
            return true;
        return false;
    }
    
    public static boolean checkWordBreak(Trie root, String A){
        
        if(A.length()==0)
            return true;
        
        for(int i=1;i<=A.length();i++)
        {
            if(search(root, A.substring(0,i)) && checkWordBreak(root, A.substring(i,A.length()))){
                return true;
            }
        }
        return false;
    }
    
    public static int wordBreak(String A, ArrayList<String> B)
    {
        //code here
        Trie root = new Trie();
        for(int i=0;i<B.size();i++){
            insert(root, B.get(i));
        }
        if(checkWordBreak(root, A))
            return 1;
        return 0;
    }
}
```

#### Method-2: DP Solution

```java
class Sol
{
    static boolean wordPresent(String key, ArrayList<String> B){
        if(B.indexOf(key)!=-1)
            return true;
        return false;
    }
    
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        if(A.length()==0)
            return 1;
        if(A.length()>0 && B.size()==0)
            return 0;
        
        int size = A.length();
        
        boolean[] wb = new boolean[size+1];
        Arrays.fill(wb,false);
        
        for(int i=1;i<=size;i++){
            if(wb[i]==false && wordPresent(A.substring(0,i), B)){
                wb[i] = true;
            }
            if(wb[i]){
                if(i==size)
                    return 1;
                int j;
                for(j=i+1;j<=size;j++){
                    if(wb[j]==false && wordPresent(A.substring(i,j), B)){
                        wb[j] = true;
                    }
                }
                if(j==size&&wb[j])
                    return 1;
            }
        }
        if(wb[size])
            return 1;
        else
            return 0;
    }
}
```


#### Editorial
* [https://www.geeksforgeeks.org/word-break-problem-trie-solution/](https://www.geeksforgeeks.org/word-break-problem-trie-solution/)