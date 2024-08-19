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