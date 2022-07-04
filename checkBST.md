[Problem Link](https://practice.geeksforgeeks.org/problems/check-for-bst/1)

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