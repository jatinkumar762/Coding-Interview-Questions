https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/


### Approach-1 Using Recursion

```java
class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    int pIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int len = inorder.length;

        // NRL
        reverse(postorder, len);

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        pIndex = -1;

        return createTree(postorder, 0, len - 1);
    }

    private TreeNode createTree(int[] postorder, int left, int right) {

        if (left > right || pIndex >= postorder.length - 1) {
            return null;
        }

        pIndex++;

        int curr = pIndex;

        TreeNode root = new TreeNode(postorder[curr]);

        if (left == right) {
            return root;
        }

        root.right = createTree(postorder, map.get(postorder[curr]) + 1, right);

        root.left = createTree(postorder, left, map.get(postorder[curr]) - 1);

        return root;
    }

    private void reverse(int[] arr, int n) {
        int tmp;

        int left = 0, right = n - 1;

        while (left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }
    }
}
```