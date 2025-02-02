
### 🚀 **0-1 BFS Algorithm Explained**

The **0-1 BFS** algorithm is an optimized version of BFS used to find the **shortest path in a graph where edge weights are only 0 or 1**. It runs faster than Dijkstra’s algorithm in this special case, with a time complexity of **O(V + E)**.  

---

### ✅ **Key Idea:**
- Instead of using a regular queue (like in BFS), we use a **double-ended queue (deque)**.  
- **0-weight edges** are given higher priority (added to the **front** of the deque).  
- **1-weight edges** are added to the **back** of the deque.  
- This ensures that nodes are processed in order of their minimum distance from the source.

---

### **Algorithm Steps:**
1. **Initialize:**
   - A `distance[]` array with `∞` for all nodes except the source (set to 0).
   - A **deque** to manage nodes efficiently.

2. **Process Nodes:**
   - Pop nodes from the front of the deque.
   - For each neighbor:
     - **If the edge weight is 0:** Add the neighbor to the **front** of the deque.
     - **If the edge weight is 1:** Add the neighbor to the **back** of the deque.
   - Update distances if a shorter path is found.

---

### **Java Implementation:**

```java
import java.util.*;

class Edge {
    int target, weight;
    Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class ZeroOneBFS {

    // 0-1 BFS Algorithm
    public static void zeroOneBFS(List<List<Edge>> graph, int source, int V) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE); // Initialize distances to ∞
        distance[source] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(source); // Start with the source node

        while (!deque.isEmpty()) {
            int current = deque.pollFirst(); // Process node from the front

            for (Edge edge : graph.get(current)) {
                int neighbor = edge.target;
                int weight = edge.weight;

                // Relaxation step
                if (distance[neighbor] > distance[current] + weight) {
                    distance[neighbor] = distance[current] + weight;

                    // Prioritize 0-weight edges
                    if (weight == 0) {
                        deque.offerFirst(neighbor); // Add to the front
                    } else {
                        deque.offerLast(neighbor);  // Add to the back
                    }
                }
            }
        }

        // Print the shortest distances from the source
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + (distance[i] == Integer.MAX_VALUE ? "Unreachable" : distance[i]));
        }
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges (u, v, weight) with weights 0 or 1
        graph.get(0).add(new Edge(1, 0));
        graph.get(0).add(new Edge(2, 1));
        graph.get(1).add(new Edge(2, 0));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 0));
        graph.get(3).add(new Edge(4, 1));
        graph.get(4).add(new Edge(5, 0));

        int source = 0;
        zeroOneBFS(graph, source, V);
    }
}
```

---

### 📊 **Sample Input & Output:**

**Graph Edges:**  
```
0 → 1 (0), 0 → 2 (1)
1 → 2 (0), 1 → 3 (1)
2 → 3 (0)
3 → 4 (1)
4 → 5 (0)
```

**Starting Node:** `0`  
**Output:**
```
Shortest distances from source 0:
Node 0: 0
Node 1: 0
Node 2: 0
Node 3: 0
Node 4: 1
Node 5: 1
```

---

### 🚀 **Explanation of the Output:**
- **0 → 1 → 2 → 3** are all reachable through **0-weight edges**, so their distances remain `0`.  
- **4** and **5** require traversing edges with weight `1`, so their distance is `1`.  

---

### 🔑 **Key Points to Remember:**
- **Deque** is used to efficiently process both 0 and 1-weight edges.  
- Works only for graphs with edge weights `0` and `1`.  
- **Time Complexity:** \( O(V + E) \) — linear time!  
- More efficient than Dijkstra’s algorithm for this specific case.

Would you like me to explain any part further or tweak the example? 🚀