Leetcode - https://leetcode.com/problems/diameter-of-binary-tree/description/

### Approach-1 here we can use tree height concept.

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

    private int maxHeight = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;

        height(root);

        return maxHeight;
    }


    private int height(TreeNode root){

        if(root==null) return 0;

        if(root.left==null && root.right==null)
            return 0;
            
        int left = root.left!=null ? height(root.left)+1 : 0 ;
        int right = root.right!=null ? height(root.right)+1 : 0;

        if(maxHeight < (left+right)){
            maxHeight = left+right;
        }
        
        return left>right?left:right;
    }
}
```

<b>Optimized code</b> </br> For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.

```java
public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
```

