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