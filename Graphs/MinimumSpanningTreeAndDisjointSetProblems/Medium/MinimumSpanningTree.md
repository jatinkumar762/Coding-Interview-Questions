
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

#### Reference:

- https://www.geeksforgeeks.org/what-is-minimum-spanning-tree-mst/