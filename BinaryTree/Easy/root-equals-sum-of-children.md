https://leetcode.com/problems/root-equals-sum-of-children/description/

https://www.geeksforgeeks.org/problems/children-sum-parent/1

```java
class Solution {
    public boolean checkTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        int left = root.left == null ? 0 : root.left.val;

        int right = root.right == null ? 0 : root.right.val;

        if (root.val != left + right) {
            return false;
        }

        if (!checkTree(root.left) || !checkTree(root.right)) {
            return false;
        }

        return true;
    }
}
```