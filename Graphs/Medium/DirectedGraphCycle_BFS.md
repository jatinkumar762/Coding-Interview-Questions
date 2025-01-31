https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/

```java
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(Integer nbr:adj.get(i)){
                inDegree[nbr]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            result.add(vertex);
            for(Integer nbr : adj.get(vertex)){
                inDegree[nbr]-=1;
                if(inDegree[nbr]==0){
                    queue.add(nbr);
                }
            }
        }
        
        return !(result.size()==V);
    }
}
```

Take an in-degree array which will keep track of 

1) Traverse the array of edges and simply increase the counter of the destination node by 1. 

```
for each node in Nodes
    indegree[node] = 0;
for each edge(src,dest) in Edges
    indegree[dest]++
```
Time Complexity: O(V+E)

2) Traverse the list for every node and then increment the in-degree of all the nodes connected to it by 1. 

```
for each node in Nodes
    If (list[node].size()!=0) then
    for each dest in list
        indegree[dest]++;
```
Time Complexity: The outer for loop will be executed V number of times and the inner for loop will be executed E number of times, Thus overall time complexity is O(V+E).

The overall time complexity of the algorithm is O(V+E) 


### DFS - Approach

```java
class Solution {
    // Function to detect cycle in a directed graph.
    boolean[] visited;
    boolean[] recStack;
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        visited = new boolean[V];
        recStack = new boolean[V];
        
        for(int i = 0; i < V; i++){
            
            if(!visited[i] && dfs(adj, i)){
                return true;
            }
        }
        
        return false;
    }
    
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr){
        
        if(visited[curr] && recStack[curr]){
            return true;
        }
        
        if(visited[curr]){
            return false;
        }
        
        visited[curr] = true;
        recStack[curr] = true;
        
        for(Integer nbr : adj.get(curr)){
            if(dfs(adj, nbr)){
                return true;
            }
        }
        
        recStack[curr] = false;
        
        return false;
    }
}
```