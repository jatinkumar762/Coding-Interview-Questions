https://leetcode.com/problems/validate-binary-search-tree/description/

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || stack.size()>0){

            while(root!=null){
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();

            if(prev!=null && prev.val>=root.val){
                return false;
            }

            prev = root;

            root = root.right;
        }
        return true;
    }
}
```