https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/


### Approach-1

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = null;

        for (int val : preorder) {
            root = insert(root, new TreeNode(val));
        }

        return root;
    }

    private TreeNode insert(TreeNode root, TreeNode newNode) {

        if (root == null) {
            return newNode;
        }

        TreeNode tmp = root, prev = null;

        while (tmp != null) {
            prev = tmp;
            if (tmp.val < newNode.val) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }

        if (prev.val < newNode.val) {
            prev.right = newNode;
        } else {
            prev.left = newNode;
        }

        return root;
    }
}
```