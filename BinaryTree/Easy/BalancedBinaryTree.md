Leetcode - https://leetcode.com/problems/balanced-binary-tree/description/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private boolean balanced = true;

    private int height(TreeNode root){

        if(root==null)
            return 0;
        
        int leftHeight = height(root.left)+1;
        int rightHeight = height(root.right)+1;

        if(balanced && Math.abs(leftHeight-rightHeight)>1 ) {
            balanced = false;
            return 0;
        }
        return leftHeight>rightHeight? leftHeight:rightHeight;
    }

    public boolean isBalanced(TreeNode root) {
        
        if(root==null)
            return true;

        int leftHeight = height(root.left)+1;
        int rightHeight = height(root.right)+1;

        if(balanced && Math.abs(leftHeight-rightHeight)>1 ) {
            balanced = false;
        }
        return balanced;
    }
}
```



Same approach in different way - https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/

```java
class Solution {

    // Function to check if a binary tree is balanced
    public boolean isBalanced(Node root) {
        // Check if the tree's height difference
        // between subtrees is less than 2
        // If not, return false; otherwise, return true
        return dfsHeight(root) != -1;
    }

    // Recursive function to calculate
    // the height of the tree
    public int dfsHeight(Node root) {
        // Base case: if the current node is NULL,
        // return 0 (height of an empty tree)
        if (root == null) return 0;

        // Recursively calculate the
        // height of the left subtree
        int leftHeight = dfsHeight(root.left);

        // If the left subtree is unbalanced,
        // propagate the unbalance status
        if (leftHeight == -1) 
            return -1;

        // Recursively calculate the
        // height of the right subtree
        int rightHeight = dfsHeight(root.right);

        // If the right subtree is unbalanced,
        // propagate the unbalance status
        if (rightHeight == -1) 
            return -1;

        // Check if the difference in height between
        // left and right subtrees is greater than 1
        // If it's greater, the tree is unbalanced,
        // return -1 to propagate the unbalance status
        if (Math.abs(leftHeight - rightHeight) > 1)  
            return -1;

        // Return the maximum height of left and
        // right subtrees, adding 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```