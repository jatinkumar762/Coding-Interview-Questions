
https://leetcode.com/problems/search-in-a-binary-search-tree/description/

```java
public TreeNode searchBST(TreeNode root, int val) {
    while(root != null && root.val != val){
        root = val<root.val? root.left:root.right;
    }
    return root;
}
```