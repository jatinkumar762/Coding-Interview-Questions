leetcode - https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/

### Approach-1 Recursion

```java
class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        calPathSum(root);

        return max;
    }

    public int calPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        //max = max > root.val ? max : root.val;

        // if (root.left == null && root.right == null) {
        //     return root.val;
        // }

        int left = Math.max(0, calPathSum(root.left));

        int right = Math.max(0, calPathSum(root.right));

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
```

[-2,-1] &rarr; -1

[2,-1] &rarr; 2
