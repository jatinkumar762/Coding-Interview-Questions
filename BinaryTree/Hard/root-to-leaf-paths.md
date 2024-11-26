https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1

### Approach-1 Using Recursion

```java
class Solution {
    
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        
        if(root == null){
            return result;
        }
        
        findPath(root, new ArrayList<>());
        
        return result;
    }
    
    private void findPath(Node root, ArrayList<Integer> path){
        
        if(root == null){
            return;
        }
        
        path.add(root.data);
        
        if(root.left==null && root.right==null){
            
            result.add(new ArrayList<>(path));
            
        } else {
        
            findPath(root.left, path);
            
            findPath(root.right, path);
        }
        
        path.remove(path.size() - 1);
    } 
}
```