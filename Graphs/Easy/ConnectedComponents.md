https://takeuforward.org/graph/connected-components-in-graphs/

## Problem: Connected Components in an Undirected Graph

- https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/

- https://neetcode.io/problems/count-connected-components (https://www.youtube.com/watch?v=8f1XPm4WOUc)

#### Approach-1: USing DFS/BFS

```java
// Java program to print connected components in
// an undirected graph
import java.util.ArrayList;
class Graph {
	// A user define class to represent a graph.
	// A graph is an array of adjacency lists.
	// Size of array will be V (number of vertices
	// in graph)
	int V;
	ArrayList<ArrayList<Integer> > adjListArray;

	// constructor
	Graph(int V)
	{
		this.V = V;
		// define the size of array as
		// number of vertices
		adjListArray = new ArrayList<>();

		// Create a new list for each vertex
		// such that adjacent nodes can be stored

		for (int i = 0; i < V; i++) {
			adjListArray.add(i, new ArrayList<>());
		}
	}

	// Adds an edge to an undirected graph
	void addEdge(int src, int dest)
	{
		// Add an edge from src to dest.
		adjListArray.get(src).add(dest);

		// Since graph is undirected, add an edge from dest
		// to src also
		adjListArray.get(dest).add(src);
	}

	void DFSUtil(int v, boolean[] visited)
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");
		// Recur for all the vertices
		// adjacent to this vertex
		for (int x : adjListArray.get(v)) {
			if (!visited[x])
				DFSUtil(x, visited);
		}
	}
	void connectedComponents()
	{
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				// print all reachable vertices
				// from v
				DFSUtil(v, visited);
				System.out.println();
			}
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		// Create a graph given in the above diagram
		Graph g = new Graph(5);

		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(3, 4);

		g.connectedComponents();
	}
}
```

#### Approach-2: Using Disjoint Set Union

* similar problem - https://leetcode.com/problems/number-of-provinces/description/
* [Solution](../Medium/NumberOfProvinces.md)

```java

```