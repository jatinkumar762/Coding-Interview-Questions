https://www.geeksforgeeks.org/problems/find-the-longest-string--170645/1

```java
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

class Trie {
    
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a']==null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.isEndOfWord = true;
    }
    
    public boolean prefix(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a']==null){
               return false;
            }
            node = node.children[ch-'a'];
        }
        return true;
    }
    
    public boolean word(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a']==null){
               return false;
            }
            node = node.children[ch-'a'];
        }
        return node.isEndOfWord;
    }
}

class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        Trie trie = new Trie();
        
        for(String word : arr){
            trie.insert(word);
        }
        
        String result = "";
        
        for(String word : arr){
            
            String prefix;
            boolean allPrefixPresent = true;
            
            for(int i=1;i<=word.length();i++){
                prefix = word.substring(0, i);
                if(!trie.word(prefix)){
                    allPrefixPresent = false;
                    break;
                }
            }    
            
            if(allPrefixPresent){
                
                int wLen = word.length();
                int rLen = result.length();
                
                if(wLen>rLen){
                    result = word;
                } 
                else if(wLen==rLen) {
                    //lexicographically smallest
                    result = result.compareTo(word)>0 ? word : result;
                }
            }
        }
        
        return result;
    }
}
```

#### Approach-2 Recursive Approach

```java
class Solution {
    
    public static String longestStringWithAllPrefix(TrieNode root, String pre)
    {
        if (root == null) {
            return pre;
        }
        
        String longest = pre;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].isEndOfWord == true) {

                String s = pre + (char)(i + 'a');
                String curr = longestStringWithAllPrefix(root.children[i], s);
                if (curr.length() > longest.length()) {
                    longest = curr;
                }
            }
        }
        return longest;
    }
    
    public static String longestString(int n, String[] arr) {
        // code here
        Trie trie = new Trie();
        
        for(String word : arr){
            trie.insert(word);
        }
        
        return longestStringWithAllPrefix(trie.root, "");
    }
}
```

#### Reference

* https://www.geeksforgeeks.org/longest-valid-word-with-all-prefixes/