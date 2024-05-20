https://leetcode.com/problems/delete-node-in-a-bst/description/

* without swap

1. node doesn't have left or right - return null
2. node only has left subtree- return the left subtree
3. node only has right subtree- return the right subtree
4. delete node has both left and right - find the minimum value in the right subtree, set its left child = delete node left child

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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null)
            return root;

        if(root.val == key){
            
            if(root.right!=null){
                TreeNode tmp = root.right;

                while(tmp.left!=null){
                    tmp = tmp.left;
                }
                tmp.left = root.left;

                return root.right;
            } else {
                return root.left;
            }
        }

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
}
```

* swap

Steps:

1. Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
2. Once the node is found, have to handle the below 4 cases
3. node doesn't have left or right - return null
4. node only has left subtree- return the left subtree
5. node only has right subtree- return the right subtree
6. node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree


```java
public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null){
        return null;
    }
    if(key < root.val){
        root.left = deleteNode(root.left, key);
    }else if(key > root.val){
        root.right = deleteNode(root.right, key);
    }else{
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }
        
        TreeNode minNode = findMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, root.val);
    }
    return root;
}

private TreeNode findMin(TreeNode node){
    while(node.left != null){
        node = node.left;
    }
    return node;
}
```