https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

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

        return root;
    }
}
```