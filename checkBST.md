[Problem](https://practice.geeksforgeeks.org/problems/check-for-bst/1)

```java
public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean checkBST(Node root, Integer min, Integer max){
        
        if(root==null)
            return true;
            
        if(root.data<min || root.data>max)
            return false;
        
        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }
    
    boolean isBST(Node root)
    {
        // code here.
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
```

*   for optimization - without recrusion - In order traversal using stack - and use property that during traversal current node val should be greater than prev node val

[Editorial](https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/)