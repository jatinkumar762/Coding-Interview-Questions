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

