https://takeuforward.org/binary-search-tree/ceil-in-a-binary-search-tree/
https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

```java
class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        
        int ceil = Integer.MAX_VALUE;
        
        while(root!=null){
            
            if(root.data==key) return key;
            
            if(root.data>key){
                ceil = root.data<ceil? root.data : ceil;    
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return ceil==Integer.MAX_VALUE?-1:ceil ;
    }
}
```