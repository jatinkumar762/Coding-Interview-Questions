https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

### Approach-1 Will work for Binary Tree also

```java
class Solution {
    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {

                if (set.contains(k - root.val)) {
                    return true;
                }

                stack.push(root);
                set.add(root.val);

                root = root.left;
            }

            root = stack.pop();

            root = root.right;
        }

        return false;
    }
}
```