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

* faster and less memory

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean rec(TreeNode root, long LB, long RB) {
      if (root == null) return true;

      if (root.val <= LB || root.val >= RB) return false;

      return rec(root.left, LB, root.val) && rec(root.right, root.val, RB);  
    }
}
```