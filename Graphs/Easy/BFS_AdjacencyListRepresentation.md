https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

```java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        queue.add(0);
        visited[0]=true;
        
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            result.add(vertex);
     
            for(int nbr:adj.get(vertex)){
             if(!visited[nbr]){
                queue.add(nbr);
                visited[nbr]=true;
             }   
            }
        }
        return result;
    }
}
```

#### Complexity

**Time Complexity:** O(V + E) where V is the total number of vertices and E is the total number of edges as we are traversing every vertex so V and also exploring each edge of all vertices so resultant sum is E.

**Space Complexity:** O(V) where V is the total number of vertices as the maximum size of queue and resultant vector is V. 