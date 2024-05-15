
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
