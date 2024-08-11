https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1


#### Approach-1 DFS
```java
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        //we dont need to maintain parent bcz of directed
        
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        for(int i=0; i<V ; i++){
            if(visited[i]==false){
                if(performDFS(i, adj, visited, recStack)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean performDFS(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, 
        boolean[] recStack){
        
        if(visited[v] && recStack[v]){
            return true;
        } else if(visited[v]){
            return false;
        }
        
        visited[v] = true;
        recStack[v] = true;
        
        for(Integer next : adj.get(v)){
            if(performDFS(next, adj, visited, recStack)){
                return true;
            }
        }
        recStack[v] = false;
        return false;
    }   
}
```