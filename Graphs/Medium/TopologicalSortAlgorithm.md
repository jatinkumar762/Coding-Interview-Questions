https://www.geeksforgeeks.org/problems/topological-sort/1

* A topological ordering is an ordering of the nodes in a directed graph where for each directed edge from node A to node B, node A appears before node B in the ordering
* Topological orderings are not unique
* Not every graph can have a topological ordering. A graph which contains a cycle cannot have a valid ordering
* only Directed Acyclic graph (DAG) can have valid topological ordering


#### Approach-1 Using DFS
```java
class Solution
{
    static int index;
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] visited = new boolean[V];
        int[] result = new int[V];
        index = V-1;
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfs(i, adj, visited, result);
            }            
        }
        
        return result;
    }
    
    static void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] result){
        
        if(visited[vertex]){
            return;
        }
        
        visited[vertex] = true;
        for(Integer neighbour : adj.get(vertex)){
            if(visited[neighbour]==false){
                dfs(neighbour, adj, visited, result);
            }
        }
        
        result[index] = vertex;
        index = index-1;
    }
}
```

TimeComplexity: O(V+E)

