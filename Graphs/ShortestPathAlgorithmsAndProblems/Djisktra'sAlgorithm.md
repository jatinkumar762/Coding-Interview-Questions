https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

* used for finding the shortest paths between nodes in a graph.
* The graph can be directed or undirected, and the edges of the graph can have non-negative weights.

**Steps of the Algorithm:**

1. Initialization:
* Start with the source node. Set the distance to the source node itself as 0.
* Set the distance to all other nodes as infinity.
* Use a priority queue (min-heap) to keep track of nodes with the shortest discovered distance that hasn't been processed yet.

2. Processing Nodes:
* Extract the node with the smallest distance from the priority queue.
* For the current node, examine all its neighbors.
* Calculate the tentative distance to each neighbor as the sum of the distance to the current node and the edge weight to that neighbor.
* If the tentative distance to a neighbor is smaller than the previously known distance, update the shortest distance to that neighbor and add the neighbor to the priority queue with the updated distance.

3. Repeat:
* Repeat the process until the priority queue is empty.

4. Output:
* Once the priority queue is empty, the shortest path from the source to each node is determined.

**Negative:**

* this algorithm does not work in negative weight


```java
class Node{
    int vertex;
    int dist;
    
    Node(int vertex, int dist){
        this.vertex = vertex;
        this.dist = dist;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V]; 
        
        // Write your code here
        Comparator<Node> nodeSort = new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if(a.dist>b.dist){
                    return 1;
                }
                else if(a.dist==b.dist){
                    return 0;
                }
                return -1;
            } 
        };
        
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(nodeSort);
        minHeap.add(new Node(S, 0));
        dist[S] = 0;
        
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            visited[node.vertex] = true;
            
            for(ArrayList<Integer> nbr : adj.get(node.vertex)){
                if(!visited[nbr.get(0)] && (node.dist + nbr.get(1)) < dist[nbr.get(0)]){
                 dist[nbr.get(0)] = node.dist + nbr.get(1);
                 minHeap.add(new Node(nbr.get(0), dist[nbr.get(0)]));
                }
            }
        }
        
        return dist;
    }
}
```

**Optimization:**

* The visited array can be removed from the algorithm to improve efficiency.
* In Dijkstra’s algorithm, once a node is processed (i.e., its shortest distance is finalized), you don't need to visit it again.
* By only updating a node’s distance if it is smaller, you ensure that each node is processed once.

```java
while (!minHeap.isEmpty()) {
    Node node = minHeap.poll();
    
    // Check all neighbors of the current node
    for (ArrayList<Integer> nbr : adj.get(node.vertex)) {
        int neighbor = nbr.get(0);
        int weight = nbr.get(1);
        
        // If a shorter path is found, update the distance
        if (dist[node.vertex] + weight < dist[neighbor]) {
            dist[neighbor] = dist[node.vertex] + weight;
            minHeap.add(new Node(neighbor, dist[neighbor]));
        }
    }
}
```


**Example:** Consider undirected graph and start vertex is A

A, B, C, D </br>
A - B 10 </br>
A - C 2 </br>
C - D 1 </br>
D - B 1

Queue Elements

- Step 1:   (C, 2) & (B, 10)
    
    - dist [0, INF, INF, INF]

- Step 2:   (D, 3) & (B, 10)

     - dist [0, INF, 2, INF]

- Step 3:   (B, 4) & (B, 10)

    - dist [0, INF, 2, 3]

- Step 4:  (B, 10)

    - dist [0, 4, 2, 3]

- Step 5: empty

**Limitations/Negatives of Dijkstra's Algorithm**

1. **Non-Negative Weights Requirement:**

* Dijkstra's algorithm does not work with graphs that contain negative weight edges. The algorithm assumes that once a node's shortest path is determined, it cannot be improved. Negative weight edges can invalidate this assumption, leading to incorrect results.

*  In such cases, other algorithms like the **Bellman-Ford algorithm** may be more appropriate.

2. **Single-Source Shortest Path:**

* The algorithm only finds the shortest path from a single source node to all other nodes. If you need shortest paths from multiple sources, you have to run the algorithm multiple times.  

3. **Time Complexity:**

* The time complexity is O(ElogV) where E is the number of edges and V is the number of vertices. This is because, for each vertex, we need to traverse all its adjacent vertices and update their distances, which takes O(E) time. Also, we use a Priority Queue which takes O(logV) time for each insertion and deletion.

4. **Space Complexity:** -  O(V)

