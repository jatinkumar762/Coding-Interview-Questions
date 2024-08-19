https://www.geeksforgeeks.org/implementation-of-bfs-using-adjacency-matrix/

```java
// Java implementation of the approach
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GFG{

static class Graph
{
	
	// Number of vertex
	int v;

	// Number of edges
	int e;

	// Adjacency matrix
	int[][] adj;

	// Function to fill the empty
	// adjacency matrix
	Graph(int v, int e)
	{
		this.v = v;
		this.e = e;
		
		adj = new int[v][v];
		for(int row = 0; row < v; row++)
			Arrays.fill(adj[row], 0);
	}
	
	// Function to add an edge to the graph
	void addEdge(int start, int e) 
	{
		
		// Considering a bidirectional edge
		adj[start][e] = 1;
		adj[e][start] = 1;
	}

	// Function to perform BFS on the graph
	void BFS(int start) 
	{
		
		// Visited vector to so that
		// a vertex is not visited more than once
		// Initializing the vector to false as no
		// vertex is visited at the beginning
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		List<Integer> q = new ArrayList<>();
		q.add(start);

		// Set source as visited
		visited[start] = true;

		int vis;
		while (!q.isEmpty())
		{
			vis = q.get(0);

			// Print the current node
			System.out.print(vis + " ");
			q.remove(q.get(0));

			// For every adjacent vertex to
			// the current vertex
			for(int i = 0; i < v; i++)
			{
				if (adj[vis][i] == 1 && (!visited[i]))
				{
					
					// Push the adjacent node to
					// the queue
					q.add(i);

					// Set
					visited[i] = true;
				}
			}
		}
	}
}

// Driver code
public static void main(String[] args)
{
	
	int v = 5, e = 4;

	// Create the graph
	Graph G = new Graph(v, e);
	G.addEdge(0, 1);
	G.addEdge(0, 2);
	G.addEdge(1, 3);

	G.BFS(0);
}
}
```

**Time Complexity:** O(N*N)

**Auxiliary Space:** O(N)
