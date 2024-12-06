[Problem](https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1/#)

```java
// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG
{
    public static Node findPre(Node root){
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
    
    public static Node findSucc(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        if(root==null)
            return;
       // add your code here
       if(root.data==key){
           if(root.left!=null)
                p.pre = findPre(root.left);
           if(root.right!=null)
                s.succ = findSucc(root.right);
           return;
       }

       if(root.data>key){
            s.succ = root;
            findPreSuc(root.left, p, s, key);
       } 
       else {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
       }
       
    }
}
```

[Editorail](https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/)

---

https://leetcode.com/problems/inorder-successor-in-bst/description/


### Approach-1

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null || p == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();

            if (root == p) {
                if (root.right != null) {
                    TreeNode tmp = root.right;

                    while (tmp.left != null) {
                        tmp = tmp.left;
                    }

                    return tmp;
                }
                return !stack.isEmpty() ? stack.peek() : null;
            }

            root = root.right;
        }

        return null;
    }
}
```