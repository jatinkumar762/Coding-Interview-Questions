https://leetcode.com/problems/maximum-width-of-binary-tree/description/


### Case-1 No Null values

* https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/

```java
class Solution {

    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 1;
        int nextCount = 0;

        int res = 0;

        while (!queue.isEmpty()) {

            res = res > count ? res : count;

            for (int i = 0; i < count; i++) {

                TreeNode tmp = queue.poll();

                if (tmp.left != null) {
                    queue.add(tmp.left);
                    nextCount++;
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                    nextCount++;
                }
            }

            count = nextCount;
            nextCount = 0;
        }

        return res;
    }
}
```

### Case-2 When null values present

* https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree-with-null-value/

* When you perform level-order traversal, you can calculate the width of the level by subtracting the index of the first node from the index of the last node at that level
* BFS (Breadth-First Search) to traverse the tree level by level.

```java

class Solution {

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNodeWithIndex> queue = new LinkedList<>();
        queue.add(new TreeNodeWithIndex(root, 0));

        int count = 1;
        int nextCount = 0;

        int maxWidth = 0;
        while (!queue.isEmpty()) {

            int min = -1, max = -1;

            for (int i = 0; i < count; i++) {

                TreeNodeWithIndex node = queue.poll();

                if (i == 0) {
                    min = node.index;
                }

                if (i == count - 1) {
                    max = node.index;
                }

                if (node.root.left != null) {
                    queue.add(new TreeNodeWithIndex(node.root.left, 2 * node.index + 1));
                    nextCount += 1;
                }

                if (node.root.right != null) {
                    queue.add(new TreeNodeWithIndex(node.root.right, 2 * node.index + 2));
                    nextCount += 1;
                }

            }

            maxWidth = Math.max(maxWidth, max - min + 1);

            count = nextCount;
            nextCount = 0;
        }

        return maxWidth;
    }

    private static class TreeNodeWithIndex {
        TreeNode root;
        int index;

        TreeNodeWithIndex(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }
}
```

**Time and Space Complexity:**

**Time Complexity:** O(n), where n is the number of nodes in the tree. 

* This is because we visit each node exactly once during the level-order traversal.

**Space Complexity:** O(n), where n is the number of nodes in the tree. 

* The space is used by the queue, which stores all nodes at a given level.
* In the worst case (a complete binary tree), the number of nodes at a level can be up to n / 2.