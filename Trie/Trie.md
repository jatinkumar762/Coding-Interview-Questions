* A Trie (pronounced as "try") is a special type of tree-like data structure that is used to efficiently store and search a large set of strings, typically words in a dictionary. 
* Tries are particularly useful when you need to perform operations like searching for a word, prefix matching, or auto-completion.

### Key Concepts of Trie

1. **Nodes and Edges:**

* Each node in a Trie represents a character of a string.
* Each edge connects two nodes and represents the next character in the string.
* The root node represents an empty string, and every path down from the root represents a word or a prefix.

2. **Structure:**

* A Trie starts with an empty root node.
* Each node contains an array or a map of children, where each child corresponds to a letter of the alphabet (or character set).
* A special flag (often a boolean) in each node indicates whether that node corresponds to the end of a valid word.

### Operations on Trie

1. **Insertion:**

* To insert a word into a Trie, start at the root node and iterate through the characters of the word.
* For each character, check if there is a corresponding child node. If not, create a new node.
* Move to the child node and continue with the next character.
* After inserting all characters, mark the last node as the end of the word.

2. **Search:**

* To search for a word, start at the root and follow the path corresponding to each character of the word.
* If you reach a node corresponding to the last character of the word, check if it's marked as the end of a word.
* If you can follow the path and the last node is marked as the end, the word exists in the Trie. Otherwise, it doesn’t.

3. **Prefix Search:**

* Similar to searching for a word, but you only need to check if you can follow the path for all characters of the prefix. If yes, then the prefix exists in the Trie.

4. **Deletion (Optional):**

* **Problem:** https://leetcode.com/problems/implement-trie-prefix-tree/

#### Approach-1 little slower 42ms

```java
/*
class Test{
    int a;
    boolean b;
}

public class MyClass {
  public static void main(String args[]) {
    Test test = new Test();
    System.out.println(test.a); //0
    System.out.println(test.b); // false
  }
}
*/


class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

class Trie {

    private final TrieNode root;

    public Trie() { 
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node = node.children.get(ch);
            if(node==null){
                return false;
            }
        }
        return node.isEndOfWord; //if last node
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            node = node.children.get(ch);
            if(node==null){
                return false;
            }
        }
        return true; //completely traversed the prefix
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

#### Approach-2 little faster 30ms

* in question already given, word and prefix consist only of lowercase English letters.

```java

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord; //default false
}

class Trie {

    private final TrieNode root;

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
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node = node.children[ch-'a'];
            if(node==null){
                return false;
            }
        }
        return node.isEndOfWord; //if last node
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            node = node.children[ch-'a'];
            if(node==null){
                return false;
            }
        }
        return true; //completely traversed the prefix
    }
}
```


### Applications of Tries

* **Autocomplete:** Used in search engines and text editors for suggesting possible completions of a word as you type.
* **Spell Checking:** Tries can efficiently check if a word exists in a dictionary and suggest corrections.
* **IP Routing:** Used in network routers to store and search IP address prefixes.
* **Longest Prefix Matching:** Useful in scenarios where you need to find the longest prefix that matches a given query.


---

```java
class Node {
    Node[] children = new Node[26];
    boolean end; // end of word

    Node(boolean end) {
        this.end = end;
    }
}

class Trie {

    private Node root;

    public Trie() {
        // empty word so true
        root = new Node(true);
    }

    public void insert(String word) {

        Node tmp = root;
        int index;

        for (char ch : word.toCharArray()) {

            index = ch - 'a';

            if (tmp.children[index] == null) {
                tmp.children[index] = new Node(false);
            }

            tmp = tmp.children[index];
        }

        tmp.end = true;
    }

    public boolean search(String word) {

        Node tmp = root;
        int index;

        for (char ch : word.toCharArray()) {

            index = ch - 'a';

            if (tmp.children[index] == null) {
                return false;
            }

            tmp = tmp.children[index];
        }

        return tmp.end;
    }

    public boolean startsWith(String prefix) {

        Node tmp = root;
        int index;

        for (char ch : prefix.toCharArray()) {

            index = ch - 'a';

            if (tmp.children[index] == null) {
                return false;
            }

            tmp = tmp.children[index];
        }

        return true;
    }
}
```