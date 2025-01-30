https://www.geeksforgeeks.org/problems/topological-sort/1

* A topological ordering is an ordering of the nodes in a directed graph where for each directed edge from node A to node B, node A appears before node B in the ordering
* Topological orderings are not unique
* Not every graph can have a topological ordering. A graph which contains a cycle cannot have a valid ordering
* only Directed Acyclic graph (DAG) can have valid topological ordering

#### Use Cases:

Topological sorting is useful in scenarios like **task scheduling**, **resolving dependencies in build systems**, and **ordering of steps in a workflow** where certain tasks must be completed before others.

#### Approach-1 Using DFS

* The idea is to perform DFS on the graph and push nodes to a stack as they finish their recursive calls. 
* Finally, popping from the stack gives the topological order

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


#### Approach-2 Using BFS

* The BFS based algorithm for Topological Sort is called **Kahn’s Algorithm**. 
* The Kahn’s algorithm has same time complexity as the DFS based algorithm.

```java
/*Complete the function below*/
class Solution
{
    static int index;
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] inDegree = new int[V];
        int[] result = new int[V];
        index = 0;
        
        for(int i=0;i<V;i++){
            for(Integer next:adj.get(i)){
                inDegree[next]+=1;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            Integer vtx = queue.poll();
            result[index++] = vtx;
            for(Integer nbr: adj.get(vtx)){
                inDegree[nbr]-=1;
                if(inDegree[nbr]==0){
                    queue.add(nbr);
                }
            }
        }
        
        return result;
    }    
}
```

