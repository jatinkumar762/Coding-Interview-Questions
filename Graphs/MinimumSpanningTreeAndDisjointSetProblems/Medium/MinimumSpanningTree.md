
* A **spanning tree** is defined as a tree-like subgraph of a connected, undirected graph that includes all the vertices of the graph. or it is a subset of the edges of the graph that forms a tree (acyclic) where every node of the graph is a part of the tree.
* A **minimum spanning tree (MST)**  is defined as a spanning tree that has the minimum weight among all the possible spanning trees
* Like a spanning tree, there can also be many possible MSTs for a graph.
* The number of vertices (V) in the graph and the spanning tree is the same.
* ( E = V-1 )
* The spanning tree should not be disconnected, as in there should only be a single source of component, not more than that.
* The spanning tree should be acyclic, which means there would not be any cycle in the tree.
* The total cost (or weight) of the spanning tree is defined as the sum of the edge weights of all the edges of the spanning tree.
* There can be many possible spanning trees for a graph.

### Prim’s Minimum Spanning Tree Algorithm

* a greedy algorithm
* designed for undirected graphs only.

**Steps:**

* It starts by selecting an arbitrary vertex and then adding it to the MST.
* Then, it repeatedly checks for the minimum edge weight that connects one vertex of MST to another vertex that is not yet in the MST. 
* This process is continued until all the vertices are included in the MST. 

&rarr; this algorithm uses priority_queue to store the vertices sorted by their minimum edge weight currently. 

#### Problem

* https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

```java
class Edge{
    int u;
    int v;
    int weight;
    
    Edge(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.weight = w;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        int sum = 0;
        boolean[] visited = new boolean[V];
        
        Comparator<Edge> edgeComparator = new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return Integer.compare(e1.weight, e2.weight);
            }
        };
        
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(edgeComparator);
        pq.add(new Edge(0, 0, 0));
        
        while(!pq.isEmpty()){
            
            Edge edge = pq.poll();
            int vertex = edge.v;
            
            if(visited[vertex]){
                continue;
            }
            
            for(int[] e : adj.get(vertex)){
                pq.add(new Edge(vertex, e[0], e[1]));
            }
            visited[vertex] = true;
            sum += edge.weight;
        }
        
        return sum;
    }
}
```

#### Reference:

- https://www.geeksforgeeks.org/what-is-minimum-spanning-tree-mst/