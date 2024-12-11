https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/


**If the problem allows you to return the new root**

```java
class Solution {
    public TreeNode flatten(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode head = null, tail = null;

        while (!stack.isEmpty() || root != null) {

            while (root != null) {

                if (head == null) {
                    head = tail = new TreeNode(root.val, null,  null);
                } else {
                    tail.right = new TreeNode(root.val, null, null);
                    tail = tail.right;
                }

                stack.push(root);

                root = root.left;
            }

            root = stack.pop();

            root = root.right;
        }

        return head;
    }

}
```


### Approach-1 Using Recusrion 0ms

```java
class Solution {

    TreeNode prev;

    public void flatten(TreeNode root) {

        if(root == null){
            return;
        }

        //first flatten right sub-tree
        flatten(root.right);

        //after right flatten left sub-tree
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

}
```

**Time Complexity:** $O(N)$

**Sapce Complexity:** $O(N)$ - recursive stack



### Approach-2 Using Stack 1ms

```java
class Solution {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }

            curr.left = null;
        }
    }

}
```