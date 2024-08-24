
* mst from a connected, undirected graph.
* greedy algorithm

### Algorithm Steps

* **Sort all edges** in non-decreasing order of their weights
* **Initialize a forest** where each vertex is a separate tree.
* **Iterate through the sorted edges** and for each edge
  * Check if the current edge connects two different trees (i.e., does not form a cycle).
  * If it does, add the edge to the MST and merge the two trees.
* Repeat until all vertices are connected, and we have (V - 1) edges in the MST, where V is the number of vertices.

&rarr; will use Disjoint Set (Union-Find) Data Structure to detect cycle

#### Problem

- https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

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
    
    static int find(int vertex, int[] parent){
        if(vertex!=parent[vertex]){
          parent[vertex] = find(parent[vertex], parent);
        }
        return parent[vertex];
    }
    
    static boolean union(int v1, int v2, int[] parent, int[] size){
        
        int pV1 = find(v1, parent);
        int pV2 = find(v2, parent);
        
        if(pV1==pV2){
            return false;
        }
        
        if(size[pV1] >= size[pV2]){
            parent[pV2] = pV1;
            size[pV1]+=size[pV2];
        } else {
            parent[pV1] = pV2;
            size[pV2]+=size[pV1];
        }
        
        return true;
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        int sum = 0;
        boolean[] visited = new boolean[V]; //default false
        int[] parent = new int[V]; //default 0
        int[] size = new int[V]; //default 0
        
        for(int i=0;i<V;i++){
            parent[i] = i;
        }
        
        Arrays.fill(size, 1);
        
    
        Comparator<Edge> edgeComparator = new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return Integer.compare(e1.weight, e2.weight);
            }
        };
        
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(edgeComparator);
        
        for(int i=0;i<adj.size();i++){
            for(int[] edge : adj.get(i)){
                pq.add(new Edge(i, edge[0], edge[1]));
            }
        }
        
        int e=0; //mst has V-1 edges
        while(!pq.isEmpty() && e<=V-1){
            
            Edge edge = pq.poll();
            int src = edge.u;
            int dst = edge.v;
            int w = edge.weight;
            
            if(union(src, dst, parent, size)){
                sum+= edge.weight;
                e+=1;
            }
        }
        
        return sum;
    }
}
```

#### Time Complexity:

&rarr; **Sorting the edges:** O(E log E), where E is the number of edges.

&rarr; **Union-Find operations:** for each edge we are doing this operation, so `O(E α(V))` time, where α is the inverse Ackermann function and V is the number of vertices.

&rarr; **Overall Time Complexity:** `O(E log E)` bcz O(E log E) > O(E α(V))

**Note:** Since E can be up to V² in a dense graph, Kruskal's algorithm is particularly efficient for sparse graphs.

#### Advantages of Kruskal's Algorithm

&rarr; **Efficiency:** Especially efficient for sparse graphs.

&rarr; **Simplicity:** Conceptually straightforward and easy to implement.

&rarr; **Flexibility:** Works well even when the graph is disconnected; it will produce a Minimum Spanning Forest.
