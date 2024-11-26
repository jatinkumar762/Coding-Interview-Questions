https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/


### Approach-1 Recursion

* If any of the given keys (n1 and n2) matches with the root, then the root is LCA (assuming that both keys are present)
* If the root doesn’t match with any of the keys, we recur for the left and right subtree. 
* The node which has one key present in its left subtree and the other key present in the right subtree is the LCA.
* If both keys lie in the left subtree, then the left subtree has LCA also
* Otherwise, LCA lies in the right subtree.  

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q)  return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left!=null && right!=null) {return root;}

        return left!=null ? left:right;
    }
}
```