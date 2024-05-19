https://takeuforward.org/binary-search-tree/floor-in-a-binary-search-tree/
https://www.geeksforgeeks.org/problems/floor-in-bst/1

```java
class Solution {
    public static int floor(Node root, int x) {
        // Code here
        
        if(root==null) return -1;
        
        int result = Integer.MIN_VALUE;
        
        while(root!=null){
            
            if(root.data == x){
                return x;
            }
            
            if(root.data < x){
                result = root.data > result ? root.data : result;
                root = root.right;
            } else {
                root = root.left;   
            }
        }
        
        return result == Integer.MIN_VALUE ? -1: result;
    
    }
}
```