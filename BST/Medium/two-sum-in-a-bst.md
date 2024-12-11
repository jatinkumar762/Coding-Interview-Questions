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

**Recursive**

```java
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
```