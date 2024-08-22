* finds the shortest paths between all pairs of vertices in a weighted graph.
* It works for both directed and undirected graphs and can handle negative edge weights 
* although it does not work for graphs containing negative weight cycles.
* The algorithm uses a dynamic programming approach to build up the shortest paths by iteratively considering whether a path that goes through an intermediate vertex is shorter than the previously known paths.


### Algorithm Overview

* The algorithm works by considering each vertex as an intermediate vertex in the path between any two vertices.
* For each pair of vertices (i,j), it checks if a path from i to 𝑗 that goes through some vertex k is shorter than the direct path from i to j.
* This is repeated for every possible intermediate vertex.
