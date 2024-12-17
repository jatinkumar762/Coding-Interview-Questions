https://www.geeksforgeeks.org/graph-and-its-representations/

In Java, a graph can be represented using various data structures. Below are some common ways to represent a graph in Java, along with code examples for each representation. We'll focus on **adjacency matrix**, **adjacency list**, and **edge list** as the primary representations.

### 1. **Adjacency Matrix Representation**
An **adjacency matrix** is a 2D array where each element represents an edge between two vertices. For an undirected graph, if there is an edge between vertex \( i \) and vertex \( j \), then both `matrix[i][j]` and `matrix[j][i]` are set to 1 (or the weight of the edge). For a directed graph, only `matrix[i][j]` is set.

#### Example Code:
```java
public class GraphAdjMatrix {
    private int[][] adjMatrix;
    private int numVertices;

    // Constructor
    public GraphAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add edge for undirected graph
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;  // for undirected graph
    }

    // Add edge for directed graph
    public void addDirectedEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
    }

    // Print the adjacency matrix
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAdjMatrix graph = new GraphAdjMatrix(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printMatrix();
    }
}
```

**Output for the above code** (Undirected graph):
```
0 1 0 0 1 
1 0 1 0 0 
0 1 0 1 0 
0 0 1 0 1 
1 0 0 1 0 
```

#### Explanation:
- The graph has 5 vertices (numbered 0 to 4).
- The edges are added using `addEdge()` for an undirected graph, where both `adjMatrix[src][dest]` and `adjMatrix[dest][src]` are set to 1.

---

### 2. **Adjacency List Representation**
An **adjacency list** is a more space-efficient representation, especially for sparse graphs. Each vertex has a list (or another collection) that contains all of its adjacent vertices.

#### Example Code:
```java
import java.util.*;

public class GraphAdjList {
    private Map<Integer, List<Integer>> adjList;

    // Constructor
    public GraphAdjList() {
        adjList = new HashMap<>();
    }

    // Add an edge (for undirected graph)
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);  // for undirected graph
    }

    // Add a directed edge
    public void addDirectedEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(dest);
    }

    // Print the adjacency list
    public void printAdjList() {
        for (Integer vertex : adjList.keySet()) {
            System.out.print("Vertex " + vertex + ": ");
            for (Integer neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList();

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printAdjList();
    }
}
```

**Output for the above code**:
```
Vertex 0: 1 4 
Vertex 1: 0 2 
Vertex 2: 1 3 
Vertex 3: 2 4 
Vertex 4: 0 3 
```

#### Explanation:
- The graph is represented using a `Map<Integer, List<Integer>>`, where the key is the vertex and the value is a list of adjacent vertices.
- We use `putIfAbsent()` to ensure that each vertex has a corresponding list, even if it has no neighbors initially.
- For an undirected graph, we add edges in both directions.

---

### 3. **Edge List Representation**
An **edge list** is simply a list of edges, where each edge is represented as a pair (or a tuple) of vertices. This is a simple representation, often used in algorithms like Kruskal's algorithm for finding the minimum spanning tree.

#### Example Code:
```java
import java.util.*;

public class GraphEdgeList {
    private List<Edge> edges;

    // Edge class to represent an edge
    static class Edge {
        int src, dest;

        // Constructor
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return "(" + src + ", " + dest + ")";
        }
    }

    // Constructor
    public GraphEdgeList() {
        edges = new ArrayList<>();
    }

    // Add edge
    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));
    }

    // Print the edge list
    public void printEdgeList() {
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }

    public static void main(String[] args) {
        GraphEdgeList graph = new GraphEdgeList();

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printEdgeList();
    }
}
```

**Output for the above code**:
```
(0, 1)
(0, 4)
(1, 2)
(2, 3)
(3, 4)
```

#### Explanation:
- An **Edge** class is created to store the source and destination vertices of an edge.
- The graph is represented as a list of `Edge` objects, and the edges are added to the list using the `addEdge()` method.
- This representation is especially useful for algorithms that need to process edges directly.

---

### 4. **Weighted Graph Representation**
For a **weighted graph**, each edge has an associated weight (or cost). We can represent this using either the adjacency matrix or adjacency list approach, but with an additional field to store the weight.

#### Example (Adjacency List for Weighted Graph):
```java
import java.util.*;

public class GraphWeightedAdjList {
    private Map<Integer, List<Edge>> adjList;

    // Edge class to represent weighted edges
    static class Edge {
        int dest;
        int weight;

        // Constructor
        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + dest + ", " + weight + ")";
        }
    }

    // Constructor
    public GraphWeightedAdjList() {
        adjList = new HashMap<>();
    }

    // Add edge with weight
    public void addEdge(int src, int dest, int weight) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight));  // for undirected graph
    }

    // Print the weighted adjacency list
    public void printAdjList() {
        for (Integer vertex : adjList.keySet()) {
            System.out.print("Vertex " + vertex + ": ");
            for (Edge edge : adjList.get(vertex)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphWeightedAdjList graph = new GraphWeightedAdjList();

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 20);
        graph.addEdge(1, 2, 30);
        graph.addEdge(2, 3, 40);
        graph.addEdge(3, 4, 50);

        graph.printAdjList();
    }
}
```

**Output for the above code**:
```
Vertex 0: (1, 10) (4, 20) 
Vertex 1: (0, 10) (2, 30) 
Vertex 2: (1, 30) (3, 40) 
Vertex 3: (2, 40) (4, 50) 
Vertex 4: (0, 20) (3, 50)

 
```

#### Explanation:
- The **Edge** class stores the destination vertex and the weight of the edge.
- The adjacency list now stores a list of `Edge` objects for each vertex, which contains both the destination vertex and the weight.

---

### Conclusion

In Java, you can represent graphs in different ways, depending on the graph's size, density, and the type of operations you need to perform. 

- **Adjacency Matrix** is useful for dense graphs and when you need fast edge lookups, but it consumes more space.
- **Adjacency List** is more space-efficient for sparse graphs and is generally used for most graph algorithms.
- **Edge List** is a simple and minimalistic representation, often used for algorithms that process edges directly.
- **Weighted Graphs** can be represented by adding weights to the edges in either adjacency lists or matrices.

Choose the appropriate representation based on the graph's characteristics and the problem you're solving.