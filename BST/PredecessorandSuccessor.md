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