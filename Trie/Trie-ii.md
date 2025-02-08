https://www.naukri.com/code360/problems/implement-trie_1387095
https://leetcode.com/problems/implement-trie-ii-prefix-tree/

The LeetCode problem "Implement Trie II (Prefix Tree)" asks you to implement a Trie (prefix tree) that supports the following operations:

1. Insert a Word: Add a word to the Trie.
2. Count Words Equal To: Return the number of words in the Trie that match a given word exactly.
3. Count Words Starting With: Return the number of words in the Trie that start with a given prefix.
4. Erase a Word: Remove a word from the Trie.

```java
import java.util.* ;
import java.io.*; 

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    int wordCount = 0;
    int prefixCount = 0;
    boolean isEndOfWord;
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a']==null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
            node.prefixCount+=1;
        }
        node.wordCount+=1;
        node.isEndOfWord = true;
    }

    public int countWordsEqualTo(String word) {
        
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a']==null){
               return 0;
            }
            node = node.children[ch-'a'];
        }
        return node.wordCount;
    }

    public int countWordsStartingWith(String word) {
        
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a']==null){
               return 0;
            }
            node = node.children[ch-'a'];
        }
        return node.prefixCount;
    }

    public void erase(String word) {
        
        if(countWordsEqualTo(word)==0){
            //word does not exist;
            return;
        }

        TrieNode node = root;
        for(char ch : word.toCharArray()){
            TrieNode child = node.children[ch-'a'];
            child.prefixCount-=1;
            if(child.prefixCount==0){
                //delete the child
                node.children[ch-'a'] = null;
                return;
            }
            node = child;
        }
        node.wordCount-=1;
    }

}
```