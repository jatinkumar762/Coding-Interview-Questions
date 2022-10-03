[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        while(stack.size()>0 || root!=null){
            
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            output.add(root.val);
            root = root.right;
        }
        
        return output;
    }
}
```