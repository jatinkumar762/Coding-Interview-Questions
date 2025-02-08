https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1

#### Approach-1 TLE Solution

```java
class GfG
{
   public static int countDistinctSubstring(String st)
   {
       //your code here
       int len = st.length();    
       char[] charArr = st.toCharArray();
    
       Set<String> uniqStringSet = new HashSet<>();
       uniqStringSet.add("");
       
       for(int i=0;i<len;i++){
           String subStr = "";
           for(int j=i;j<len;j++){
               subStr += charArr[j];
               uniqStringSet.add(subStr);
           }
       }
       return uniqStringSet.size();
   }
}
```

#### Approach-2 Efficient code

```java
class TrieNode {
    //input given
    //Given a string of length N of lowercase alphabet characters.
    TrieNode[] childrens = new TrieNode[26];
    boolean isEndOfWord;
}

/*You are required to complete this method */
class GfG
{
   public static int countDistinctSubstring(String st)
   {
       //your code here
       int len = st.length();    
       char[] charArr = st.toCharArray();
        
       TrieNode root = new TrieNode();
       int count = 1; //empty string
       
       for(int i=0;i<len;i++){
           TrieNode tmp = root;
           for(int j=i;j<len;j++){
               char ch = charArr[j];
               if(tmp.childrens[ch-'a']==null){
                    tmp.childrens[ch-'a'] = new TrieNode();
                    tmp.isEndOfWord = true;
                    count+=1;
                }
                tmp = tmp.childrens[ch-'a'];
           }
       }
       return count;
   }
}
```