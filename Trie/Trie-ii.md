https://www.naukri.com/code360/problems/implement-trie_1387095

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
        // Write your code here.
        root = new TrieNode();
    }

    public void insert(String word) {
        // Write your code here.
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
        // Write your code here.
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
        // Write your code here.
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
        // Write your code here.
        if(countWordsEqualTo(word)==0){
            //word does not exist;
            return;
        }

        TrieNode node = root;
        for(char ch : word.toCharArray()){
            TrieNode child = node.children[ch-'a'];
            child.prefixCount-=1;
            if(child.prefixCount==0){
                node.children[ch-'a'] = null;
                return;
            }
            node = child;
        }
        node.wordCount-=1;
    }

}
```