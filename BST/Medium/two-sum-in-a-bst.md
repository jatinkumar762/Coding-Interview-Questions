https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

**To-Do:** BST Iterator


### Approach-1 Will work for Binary Tree also - 4ms

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

**Recursive** - 3ms

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

### Approach-2 Store InOrder Traversal 4ms

* InOrder Traversal - sorted

```java
class Solution {
    public boolean findTarget(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        List<Integer> inOrder = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            inOrder.add(root.val);

            root = root.right;
        }

        int len = inOrder.size();

        int left = 0, right = len - 1, sum;

        while (left < right) {

            sum = inOrder.get(left) + inOrder.get(right);

            if (sum == k) {
                return true;
            }

            if (sum < k) {
                left++;
            } else {
                right--;
            }

        }

        return false;
    }
}
```

### Approach-3 BFS and Set 4ms

```java
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
}
```