[Clone Graph](https://leetcode.com/problems/clone-graph/)

```java
class Solution {
    
    public void DFS(Node clone, Node original, Node[] visited){
        visited[original.val] = clone;
        
        for(Node neighbour : original.neighbors){
            if(visited[neighbour.val]==null){
                
               Node newNode = new Node(neighbour.val);
               clone.neighbors.add(newNode);
               DFS(newNode, neighbour, visited);
                
            } else {
                clone.neighbors.add(visited[neighbour.val]);
            }
        }
    }
    
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        int val = node.val;       
        Node clone = new Node(val);
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        
        DFS(clone, node, visited);
        
        return clone;
    }
}
```