https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

### Approach-1 Using Recursion

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //WE ARE GOING TO USE BST PROPERTY TO SOLVE FASTER
        //WE ARE CONSIDERING P node IS LESS THAN Q node, IF NOT WE ARE Swapping Node ptr

        /*
            if we swap val, will give wrong answer -> and also invalidate bst property
            [2,1], Node p = 2, Node q = 1
            correct result -> 2
        */
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }

        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        //left child containing values less than the parent node 
        //and the right child containing values greater than the parent node.

        TreeNode left = null, right = null;

        if (root.val > p.val && root.val < q.val) {
            left = lowestCommonAncestor(root.left, p, q);
            right = lowestCommonAncestor(root.right, p, q);
        } else if (root.val < p.val) {
            right = lowestCommonAncestor(root.right, p, q);
        } else if (root.val > q.val) {
            left = lowestCommonAncestor(root.left, p, q);
        }

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
```

**Another way to approach**

```java

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root != null && (root == p || root == q))
            return root;

        /*
         * Recursive Approach
         * if(root.val > p.val && root.val>q.val) {
         * return lowestCommonAncestor(root.left, p, q);
         * }
         * else if(root.val < p.val && root.val < q.val){
         * return lowestCommonAncestor(root.right, p, q);
         * }
         * return root;
         */

        
        while (root != null) {

            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        

        /*
            //multiplication will be +ve only
            // if root greater than both p and q
            // if root smaller than both p and q
            while ((root.val - p.val) * (root.val - q.val) > 0){
                //this solution will not work
                //bcz of integer overflow
                root = p.val < root.val ? root.left : root.right;
            }
            
            //root = [0,-1000000000,1000000000]
            //p = -1000000000
            //q = 1000000000
        */


        return root;
    }
}
```

**Time COmplexity:** $O(H)$