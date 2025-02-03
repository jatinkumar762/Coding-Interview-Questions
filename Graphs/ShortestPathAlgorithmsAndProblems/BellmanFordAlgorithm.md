https://www.youtube.com/watch?v=FtN3BYH2Zes
https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/

* single source shortest path algorithm
* This algorithm can be used on both weighted and unweighted graphs.
* follows Dynamic Programming approach, Dijkstra’s follows greedy
* Bellman-Ford is slower than Dijkstra’s algorithm
* capable of handling graphs with negative edge weights,
* The shortest path cannot be found if there exists a negative cycle in the graph. (means negative edge present in cycle)
* If we continue to go around the negative cycle an infinite number of times, then the cost of the path will continue to decrease
* Bellman-Ford is also capable of detecting negative cycles, which is an important feature.

**Intuition**

1. primary principle is that it starts with a single source and calculates the distance to each node. 
2. The distance is initially unknown and assumed to be infinite
3. but as time goes on, the algorithm relaxes those paths by identifying a few shorter paths.
4. Hence it is said that Bellman-Ford is based on “Principle of Relaxation“.

**Principle of Relaxation of Edges for Bellman-Ford:**

1. graph has N vertices
2. all the edges should be relaxed N-1 times to compute the single source shortest path.
3. In order to detect whether a negative cycle exists or not, relax all the edge one more time and if the shortest distance for any node reduces then we can say that a negative cycle exists.

**Why Relaxing Edges N-1 times, gives us Single Source Shortest Path?**

1. a shortest path between two vertices can have at most N-1 edges, where N is the number of vertices.
2. By relaxing edges N-1 times, the Bellman-Ford algorithm ensures that the distance estimates for all vertices have been updated to their optimal values
3. If a graph contains a negative-weight cycle reachable from the source vertex, the algorithm can detect it after N-1 iterations, since the negative cycle disrupts the shortest path lengths.
4. In summary, relaxing edges N-1 times in the Bellman-Ford algorithm guarantees that the algorithm has explored all possible paths of length up to N-1, which is the maximum possible length of a shortest path in a graph with N vertices

* A graph which takes more than n-1 edges for any path, its not possible

**Note:**

1. the Bellman-Ford algorithm is typically applied to directed graphs. 
2. If you want to apply Bellman-Ford to an undirected graph, you can treat it as a directed graph by replacing each undirected edge with two directed edges, one in each direction
3. **Negative Weight Cycles:** In an undirected graph, if an edge has a negative weight, it can easily create a negative weight cycle when treated as bidirectional, making it less common to use Bellman-Ford directly on undirected graphs without first converting them to directed form.



https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

```java
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int max_dis = 100000000; //If a vertices can't be reach from the s then mark the distance as 10^8
        int[] distance = new int[V];
        Arrays.fill(distance, max_dis);
        distance[S] = 0;
        
        //relax edge v-1 times
        for(int i=1;i<V;i++){
            for(ArrayList<Integer> edge:edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                //distance[u]!=max_dis why need this check?
                //bcz in case of negative weight, sum will be less than max_dis
                if(distance[u]!=max_dis && distance[v] > distance[u] + w){
                    distance[v] = distance[u]+w;
                }
            }
        }
        
        //Vth iteration
        //check if negative cycle exist
        for(ArrayList<Integer> edge:edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if(distance[u]!=max_dis && distance[v] > distance[u] + w) {
                //negative cycle exist
                return new int[]{-1};
            }
        }
        return distance;
    }
}
```

#### Time Complexity: O(V*E)

The time complexity is O(V×E), making it less efficient than Dijkstra's algorithm for graphs without negative weights, but essential for handling more complex cases with negative weight cycles.


**Note:**

* Dijkstra’s algorithm is not suitable for graphs with negative weight edges because it relies on the assumption that once a node’s shortest path is found, it cannot be improved.

* If your graph contains negative weight edges, the Bellman-Ford algorithm is a better choice. It handles negative weights, finds the shortest paths, and detects negative weight cycles.

