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