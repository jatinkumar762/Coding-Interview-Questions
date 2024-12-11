https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/


### Approach-1 Using Recursion

```java
class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int pIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        pIndex = -1;

        return createTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode createTree(int[] preorder, int left, int right) {

        if (left > right || pIndex >= preorder.length-1) {
            return null;
        }

        pIndex++;
        
        int curr = pIndex;

        TreeNode root = new TreeNode(preorder[curr]);

        if (left == right) {
            return root;
        }

        root.left = createTree(preorder, left, map.get(preorder[curr]) - 1);

        root.right = createTree(preorder, map.get(preorder[curr]) + 1, right);

        return root;
    }
}
```
