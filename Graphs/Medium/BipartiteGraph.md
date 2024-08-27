https://www.geeksforgeeks.org/problems/bipartite-graph/1

* A bipartite graph is a graph whose vertices can be divided into two disjoint and independent sets U and V such that every edge connects a vertex in U to one in V.
* In other words, there are no edges between vertices within the same set.

Characteristics:

1. **Two sets of vertices:** The graph is divided into two sets where no two vertices within the same set are adjacent.

2. **Colorability:** A bipartite graph can be colored using two colors such that no two adjacent vertices share the same color.

3. **Matching:** Bipartite graphs are often used in problems involving matching, such as job assignments where one set of vertices represents jobs and the other represents workers.

4. **No odd-length cycles:** A bipartite graph cannot contain any odd-length cycles, as this would require vertices from the same set to be connected by an edge.

5. **Maximum degree is bounded by the size of the smaller set:** The maximum degree of a vertex in a bipartite graph is equal to the size of the smaller set.


```java
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        int[] color = new int[V];
        
        for(int i=0;i<V;i++) {
            
            if(!visited[i]) {
                visited[i] = true;
                color[i] = 1;
                
                Queue<Integer> pq = new LinkedList<Integer>();
                pq.add(i);
                
                while(!pq.isEmpty()){
                    
                    int vertex = pq.poll();
                    
                    for(Integer nbr : adj.get(vertex)){
                        if(!visited[nbr]){
                            visited[nbr] = true;
                            color[nbr] = -1 * color[vertex];
                            pq.add(nbr);
                        } else {
                            if(color[nbr]==color[vertex]){
                                return false;
                            }
                        }
                    }
                    
                }
            }
        }
        return true;
    }
}
```

#### Reference:

* https://www.geeksforgeeks.org/what-is-bipartite-graph/