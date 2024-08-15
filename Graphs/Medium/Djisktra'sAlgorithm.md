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
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
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
            for(ArrayList<Integer> nbr : adj.get(node.vertex)){
                if((node.dist + nbr.get(1)) < dist[nbr.get(0)]){
                 dist[nbr.get(0)] = node.dist + nbr.get(1);
                 minHeap.add(new Node(nbr.get(0), dist[nbr.get(0)]));
                }
            }
        }
        
        return dist;
    }
}
```