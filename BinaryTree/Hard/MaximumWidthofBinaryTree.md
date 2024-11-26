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

```java

```