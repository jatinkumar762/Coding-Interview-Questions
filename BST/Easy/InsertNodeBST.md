https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
https://takeuforward.org/binary-search-tree/insert-a-given-node-in-binary-search-tree/

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode newNode = new TreeNode(val);

        if(root==null){
            return newNode;
        }

        TreeNode current = root;
        TreeNode previous = null;
        
        while(current!=null){

            previous = current;
            if(current.val<val){
                current = current.right;
            } else {
                current = current.left;
            }

        }

        if(previous.val<val){
            previous.right = newNode;
        } else {
            previous.left = newNode;
        }

        return root;
    }
}
```


#### Leetcode Solutions

* Without using 2 variables

```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        
        TreeNode curr = root;
        
        while(true){
            if(curr.val < val){
                if(curr.right != null) curr = curr.right;
                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if(curr.left != null) curr = curr.left;
                else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
```

* Recursive approach

```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}
```