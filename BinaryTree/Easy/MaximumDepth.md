

1. Depth-first-search

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
    public int maxDepth(TreeNode root) {
        
        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
            return 1;

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return left<right? right:left;
    }
}
```


2. Breadth First Search

* Use the concept of level by level traversal, count of level

  https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/

```java
class Solution {
    // Function to find the
    // maximum depth of a binary tree
    // using level order traversal
    int maxDepth(Node root) {
        // If the root is NULL
        // (empty tree), depth is 0
        if (root == null) {
            return 0;
        }

        // Create a queue for
        // level order traversal
        Queue<Node> q = new LinkedList<>();
        int level = 0;

        // Push the root node into the queue
        q.add(root);

        // While there are nodes in the queue
        while (!q.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = q.size();

            // Process all nodes
            // at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                Node front = q.poll();

                // Enqueue left child if exists
                if (front.left != null) {
                    q.add(front.left);
                }

                // Enqueue right child if exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to
            // move to the next level
            level++;
        }
        // Return the level, which represents
        // the maximum depth of the tree
        return level;
    }
}
```