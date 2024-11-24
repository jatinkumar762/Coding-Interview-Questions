
## Pre-Order Traversal

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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                result.add(root.val);

                stack.push(root);

                root = root.left;
            }
            root = stack.pop();

            root = root.right;
        }

        return result;
    }
}
```




## In-Order Traversal

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || stack.size()>0){

            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);

            root = root.right;
        }

        return result;
    }
}
```

## Post-Order Traversal

* LRN 
    - NRL -> and reverse the output array 


<b>Note -</b> if i use, LinkedList instead of ArrayList, then i can reduce so much run time of the program.

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        //List<Integer> result = new ArrayList<>();
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || stack.size()>0){

            while(root!=null){
                //result.add(root.val);
                result.addFirst(root.val); // Reverse the process of preorder
                stack.push(root); 
                root = root.right; // Reverse the process of preorder
            }

            root = stack.pop();

            if(root!=null){
                root = root.left; // Reverse the process of preorder
            }
        }

        //Collections.reverse(result);

        return result;
    }
}
```






#### Reference
[Preorder, Inorder, and Postorder Iteratively Summarization](https://leetcode.com/problems/binary-tree-postorder-traversal/solutions/45551/preorder-inorder-and-postorder-iteratively-summarization/)


