
1. https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
2. https://leetcode.com/problems/binary-tree-right-side-view/description/

#### Approach-1 Using BFS, level by level order traversal

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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();

        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()>0){

            int size = queue.size();

            for(int i=0;i<size;i++) {

                root = queue.poll();

                if(i==0){
                    result.add(root.val);
                }

                if(root.right!=null){
                    queue.add(root.right);
                }

                if(root.left!=null){
                    queue.add(root.left);
                }

            }
        }

        return result;
    }
}
```

### Optimized Approach

The core idea of this algorithm:

1. Each depth of the tree only select one node.
2. View depth is current size of result list.

To get the left and right view of a Binary Tree, we perform a depth-first traversal of the Binary Tree while keeping track of the level of each node. For both the left and right view, we’ll ensure that only the first node encountered at each level is added to the result vector.

```java
class Solution {
    
    private List<Integer> result = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null) return result;

        rightView(root, 0);

        return result;
    }

    private void rightView(TreeNode root, int currDepth){

        if(root == null) return;

        if(result.size() == currDepth){
            result.add(root.val);
        }

        rightView(root.right, currDepth+1);
        rightView(root.left, currDepth+1);
    }
}
```
