Problem - https://leetcode.com/problems/same-tree/description/

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // Base case: if both trees are null, they are identical
        if(p==null && q==null) return true;

        // If only one tree is null or the values are different, they are not identical
        if(p==null || q==null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        /*
        can't use inorder same then same
            A                 B
        B      C                 A
                                    C
        have same inorder
        */
    }
}
```
